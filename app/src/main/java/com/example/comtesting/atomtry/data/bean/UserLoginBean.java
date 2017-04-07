package com.example.comtesting.atomtry.data.bean;


/**
 * Created by atom on 2017/2/24.
 */
public class UserLoginBean {
        /**
         * user : {"id":"87","hxun":"18981375816","uuid":"ab4df1a0-6ad1-11e6-b989-55a333335897","nick_name":"pang","cover":"e940fbcd-8b5a-4f6c-94ae-d35baf047884.jpg","image":"e940fbcd-8b5a-4f6c-94ae-d35baf047884.jpg","real_name":"Ho","tel":"18981375816","birthday":"2000-01-09","constellation":"","shuxiang":"","age":"16","sex":"","emotion":"","motto":"你的肉体在我心","profession":"","school":"","province":"510000","city":"511100","district":"511111","blood_type":"","Authorization":"a9c299a614de15626c85dde39ba07319","meta":{"$1":"true","$0":"false"}}
         * Authorization : a9c299a614de15626c85dde39ba07319
         */
        private UserBean user;
        private String Authorization;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getAuthorization() {
            return Authorization;
        }

        public void setAuthorization(String Authorization) {
            this.Authorization = Authorization;
        }

        public static class UserBean {
            /**
             * id : 87
             * hxun : 18981375816
             * uuid : ab4df1a0-6ad1-11e6-b989-55a333335897
             * nick_name : pang
             * cover : e940fbcd-8b5a-4f6c-94ae-d35baf047884.jpg
             * image : e940fbcd-8b5a-4f6c-94ae-d35baf047884.jpg
             * real_name : Ho
             * tel : 18981375816
             * birthday : 2000-01-09
             * constellation :
             * shuxiang :
             * age : 16
             * sex :
             * emotion :
             * motto : 你的肉体在我心
             * profession :
             * school :
             * province : 510000
             * city : 511100
             * district : 511111
             * blood_type :
             * Authorization : a9c299a614de15626c85dde39ba07319
             * meta : {"$1":"true","$0":"false"}
             */

            private String id;
            private String hxun;
            private String uuid;
            private String nick_name;
            private String cover;
            private String image;
            private String real_name;
            private String tel;
            private String birthday;
            private String constellation;
            private String shuxiang;
            private String age;
            private String sex;
            private String emotion;
            private String motto;
            private String profession;
            private String school;
            private String province;
            private String city;
            private String district;
            private String blood_type;
            private String Authorization;
            private MetaBean meta;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getHxun() {
                return hxun;
            }

            public void setHxun(String hxun) {
                this.hxun = hxun;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getConstellation() {
                return constellation;
            }

            public void setConstellation(String constellation) {
                this.constellation = constellation;
            }

            public String getShuxiang() {
                return shuxiang;
            }

            public void setShuxiang(String shuxiang) {
                this.shuxiang = shuxiang;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getEmotion() {
                return emotion;
            }

            public void setEmotion(String emotion) {
                this.emotion = emotion;
            }

            public String getMotto() {
                return motto;
            }

            public void setMotto(String motto) {
                this.motto = motto;
            }

            public String getProfession() {
                return profession;
            }

            public void setProfession(String profession) {
                this.profession = profession;
            }

            public String getSchool() {
                return school;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getBlood_type() {
                return blood_type;
            }

            public void setBlood_type(String blood_type) {
                this.blood_type = blood_type;
            }

            public String getAuthorization() {
                return Authorization;
            }

            public void setAuthorization(String Authorization) {
                this.Authorization = Authorization;
            }

            public MetaBean getMeta() {
                return meta;
            }

            public void setMeta(MetaBean meta) {
                this.meta = meta;
            }

            public static class MetaBean {
                /**
                 * $1 : true
                 * $0 : false
                 */

                private String $1;
                private String $0;

                public String get$1() {
                    return $1;
                }

                public void set$1(String $1) {
                    this.$1 = $1;
                }

                public String get$0() {
                    return $0;
                }

                public void set$0(String $0) {
                    this.$0 = $0;
                }
            }
        }
}
