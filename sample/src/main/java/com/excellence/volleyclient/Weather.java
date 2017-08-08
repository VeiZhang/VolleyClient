package com.excellence.volleyclient;

import java.util.List;

/**
 * <pre>
 *     author : VeiZhang
 *     blog   : http://tiimor.cn
 *     time   : 2017/8/8
 *     desc   : 天气信息
 * </pre>
 */

public class Weather
{
    /**
     * message : Success !
     * status : 200
     * city : 珠海
     * count : 5
     * data : {"shidu":"70%","pm25":9,"pm10":18,"quality":"优","wendu":"32","ganmao":"各类人群可自由活动","yesterday":{"date":"07日星期一","sunrise":"05:59","high":"高温 34.0℃","low":"低温 28.0℃","sunset":"19:03","aqi":28,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"},"forecast":[{"date":"08日星期二","sunrise":"06:00","high":"高温 35.0℃","low":"低温 28.0℃","sunset":"19:02","aqi":18,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"09日星期三","sunrise":"06:00","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:02","aqi":44,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"10日星期四","sunrise":"06:00","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:01","aqi":49,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"11日星期五","sunrise":"06:01","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:00","aqi":47,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"今日有短时阵雨，外出请携带雨具"},{"date":"12日星期六","sunrise":"06:01","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:00","aqi":46,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]}
     */

    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 70%
         * pm25 : 9
         * pm10 : 18
         * quality : 优
         * wendu : 32
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"07日星期一","sunrise":"05:59","high":"高温 34.0℃","low":"低温 28.0℃","sunset":"19:03","aqi":28,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}
         * forecast : [{"date":"08日星期二","sunrise":"06:00","high":"高温 35.0℃","low":"低温 28.0℃","sunset":"19:02","aqi":18,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"绵绵的云朵，形状千变万化"},{"date":"09日星期三","sunrise":"06:00","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:02","aqi":44,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"10日星期四","sunrise":"06:00","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:01","aqi":49,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"突如其来的雨，总叫让人措手不及"},{"date":"11日星期五","sunrise":"06:01","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:00","aqi":47,"fx":"无持续风向","fl":"<3级","type":"阵雨","notice":"今日有短时阵雨，外出请携带雨具"},{"date":"12日星期六","sunrise":"06:01","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"19:00","aqi":46,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}]
         */

        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 07日星期一
             * sunrise : 05:59
             * high : 高温 34.0℃
             * low : 低温 28.0℃
             * sunset : 19:03
             * aqi : 28
             * fx : 无持续风向
             * fl : <3级
             * type : 多云
             * notice : 悠悠的云里有淡淡的诗
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 08日星期二
             * sunrise : 06:00
             * high : 高温 35.0℃
             * low : 低温 28.0℃
             * sunset : 19:02
             * aqi : 18
             * fx : 无持续风向
             * fl : <3级
             * type : 多云
             * notice : 绵绵的云朵，形状千变万化
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", city='" + city + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
