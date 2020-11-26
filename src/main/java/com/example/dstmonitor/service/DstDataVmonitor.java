package com.example.dstmonitor.service;


import org.json.simple.parser.ParseException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class DstDataVmonitor {


        //3.添加定时任务
        @Scheduled(cron = "0 1 * * * ?")
        //或直接指定时间间隔，例如：5秒
        //@Scheduled(fixedRate=5000)
        private void configureTasks() throws ParseException, java.text.ParseException {
            //  System.err.println("执行静态定时任务时间: " + LocalDateTime.now());

            //   String dataVupdateTime="http://10.210.168.7:9999/api/query/c886de5b-e2b7-4e1e-9f32-8a508abf10ef/main-title_SAymn.source?";

            //   String str2 = getWebHtml(dataVupdateTime);
            String str2 = "202011261800";
            String dataTimeStr = str2.replaceAll("[^0-9.]", "");

            System.out.println("数据时间" + dataTimeStr);


            /**
             *    * 获取现在时间
             *    *
             *    * @return返回短时间格式 yyyy-MM-dd
             */
            DateFormat format = new SimpleDateFormat("yyyyMMddhhmm");
             Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
            String nowtimeStr = formatter.format(currentTime);

          //   System.out.println("now time:" + nowtimeStr);
            //  System.out.println("数据时间戳:"+dateToStamp(dataTimeStr));//日期格式转时间戳
            //  System.out.println("现在时间戳:"+dateToStamp(nowtimeStr));//日期格式转时间戳

            //时间戳差（换算成分钟）
            long diffMinitues = (format.parse(nowtimeStr).getTime() - format.parse(dataTimeStr).getTime()) / (1000 * 60);
            System.out.println("最新数据时间戳与当前时间的差分钟" + diffMinitues);

            while (diffMinitues > 90) {
                //发送告警信息
                System.out.println(currentTime+"发送告警");
                break;
            }

            System.out.println("出入境数据更新时间" + nowtimeStr);


        }

    /**
     * 将时间转换成时间戳
     * @param nowtimeStr
     * @return
     * @throws ParseException
     * @throws java.text.ParseException
     */
        private String dateToStamp(String nowtimeStr) throws ParseException, java.text.ParseException {
            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = simpleDateFormat.parse(nowtimeStr);
            long ts = date.getTime();
            res = String.valueOf(ts);
            return res;
        }


        public String getWebHtml(String domain) {

            StringBuffer sb = new StringBuffer();
            InputStream is = null;
            InputStreamReader isr = null;
            BufferedReader in = null;
            try {
                java.net.URL url = new java.net.URL(domain);
                is = url.openStream();
                isr = new InputStreamReader(is, "utf-8");
                in = new BufferedReader(isr);
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                in.close();


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) {
                        in.close();
                        in = null;
                    }
                    if (isr != null) {
                        isr.close();
                        isr = null;
                    }
                    if (is != null) {
                        is.close();
                        is = null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }


}
