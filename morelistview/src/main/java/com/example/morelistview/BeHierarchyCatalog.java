package com.example.morelistview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Majin
 * @date: 2020/7/17$
 * @desc: 解析 知识体系 目录json
 */
public class BeHierarchyCatalog {
    @Override
    public String toString() {
        return "BeanParent{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }

    /**
     * data : {"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_serial_no":0,"entity_created":"2020-05-27T16:54:06","entity_status":1,"hier_uuid":"32fb48a0e35a4ce2a6c34aec5ee9f242","id":658,"sec_count":16,"sections":[{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:16:24","entity_status":1,"has_new":0,"id":2285,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"2b5c9bf6ef824141a85c7ade5a7ae523","rank":1,"sec_type":1,"seg_count":1,"serial_no":"1.1","title":"时间线","uuid":"ac8a11577ba74c939a30a0779e6c6063","description":"存放内容的默认章节"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:20:46","entity_status":1,"has_new":0,"id":2288,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":1,"sec_type":1,"seg_count":3,"serial_no":"3.1","title":"看空方：雪湖资本","uuid":"3c77d0ea999341aa84ec377c170a863e"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:17","entity_status":1,"has_new":0,"id":2293,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":1,"sec_type":1,"seg_count":2,"serial_no":"3.4.1","title":"third bridge","uuid":"559e34a2a31241ee88fff6c65d77c999"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T16:56:28","entity_status":1,"has_new":0,"id":2284,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":2,"sec_type":1,"seg_count":3,"serial_no":"1","title":"事件进程","uuid":"2b5c9bf6ef824141a85c7ade5a7ae523"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:19:36","entity_status":1,"has_new":0,"id":2286,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"2b5c9bf6ef824141a85c7ade5a7ae523","rank":2,"sec_type":1,"seg_count":2,"serial_no":"1.2","title":"相关资讯","uuid":"66eafd243dc44fe7b0f39c234fffef5e"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:27:10","entity_status":1,"has_new":0,"id":2289,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":2,"sec_type":1,"seg_count":3,"serial_no":"3.2","title":"做空方：浑水","uuid":"058e2895e9f24c7c8ef1984191d2c0b0"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:25","entity_status":1,"has_new":0,"id":2294,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":2,"sec_type":1,"seg_count":1,"serial_no":"3.4.2","title":"汇生咨询","uuid":"384baec9cdc348928d3cee434e290ae0"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:42:35","entity_status":1,"has_new":0,"id":2290,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":3,"sec_type":1,"seg_count":3,"serial_no":"3.3","title":"审计方：安永","uuid":"0d1d0f9c945f4494bb8335f7757f941d"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:52:00","entity_status":1,"has_new":0,"id":2291,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":3,"sec_type":1,"seg_count":3,"serial_no":"2","title":"事件影响","uuid":"5ad49391946c43619804d854c62502d6"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:30","entity_status":1,"has_new":0,"id":2295,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":3,"sec_type":1,"seg_count":0,"serial_no":"3.4.3","title":"久谦咨询","uuid":"24bef89ad54f403283b4db1576f1fb46"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:19:56","entity_status":1,"has_new":0,"id":2287,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":4,"sec_type":1,"seg_count":12,"serial_no":"3","title":"事件相关利益体","uuid":"0b24f0bf201a4f1d991b0629a750ee05"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:53:29","entity_status":1,"has_new":0,"id":2292,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":4,"sec_type":1,"seg_count":3,"serial_no":"3.4","title":"执行机构","uuid":"28a404f7552149b6860ee830ea2ca8ff"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T18:00:36","entity_status":1,"has_new":0,"id":2296,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":5,"sec_type":1,"seg_count":2,"serial_no":"4","title":"瑞幸股市动态","uuid":"f38aa7fc643d42079de685157a464c48"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T18:45:15","entity_status":1,"has_new":0,"id":2300,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":6,"sec_type":1,"seg_count":1,"serial_no":"5","title":"舆论趋势","uuid":"235a57f5a5294454a6fa7bd50f21d965"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T19:23:14","entity_status":1,"has_new":0,"id":2304,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":7,"sec_type":1,"seg_count":4,"serial_no":"6","title":"带来的启示","uuid":"1ac9b9225e8840c3afc597cecbc8abbb"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"description":"存放内容的默认章节","entity_created":"2020-05-27T16:54:07","entity_status":1,"has_new":0,"id":2283,"is_default":1,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":1,"sec_type":1,"seg_count":0,"serial_no":"7","title":"默认章节","uuid":"ecbb1903d30a4976a459f15dd5cfda44"}],"seg_count":25,"uuid":"3c782451d78b44b89d95204dc2590899","version":1}
     * status : 200
     */

    private DataBean data;
    private int      status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "act_uuid='" + act_uuid + '\'' +
                    ", app_uuid='" + app_uuid + '\'' +
                    ", auto_serial_no=" + auto_serial_no +
                    ", entity_created='" + entity_created + '\'' +
                    ", entity_status=" + entity_status +
                    ", hier_uuid='" + hier_uuid + '\'' +
                    ", id=" + id +
                    ", sec_count=" + sec_count +
                    ", seg_count=" + seg_count +
                    ", uuid='" + uuid + '\'' +
                    ", version=" + version +
                    ", sections=" + sections +
                    '}';
        }

        /**
         * act_uuid : 0d10cca88721404c91b79dbd7a8f5f91
         * app_uuid : 6290fa1543894c209df6efa954bfb066
         * auto_serial_no : 0
         * entity_created : 2020-05-27T16:54:06
         * entity_status : 1
         * hier_uuid : 32fb48a0e35a4ce2a6c34aec5ee9f242
         * id : 658
         * sec_count : 16
         * sections : [{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:16:24","entity_status":1,"has_new":0,"id":2285,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"2b5c9bf6ef824141a85c7ade5a7ae523","rank":1,"sec_type":1,"seg_count":1,"serial_no":"1.1","title":"时间线","uuid":"ac8a11577ba74c939a30a0779e6c6063"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:20:46","entity_status":1,"has_new":0,"id":2288,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":1,"sec_type":1,"seg_count":3,"serial_no":"3.1","title":"看空方：雪湖资本","uuid":"3c77d0ea999341aa84ec377c170a863e"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:17","entity_status":1,"has_new":0,"id":2293,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":1,"sec_type":1,"seg_count":2,"serial_no":"3.4.1","title":"third bridge","uuid":"559e34a2a31241ee88fff6c65d77c999"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T16:56:28","entity_status":1,"has_new":0,"id":2284,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":2,"sec_type":1,"seg_count":3,"serial_no":"1","title":"事件进程","uuid":"2b5c9bf6ef824141a85c7ade5a7ae523"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:19:36","entity_status":1,"has_new":0,"id":2286,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"2b5c9bf6ef824141a85c7ade5a7ae523","rank":2,"sec_type":1,"seg_count":2,"serial_no":"1.2","title":"相关资讯","uuid":"66eafd243dc44fe7b0f39c234fffef5e"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:27:10","entity_status":1,"has_new":0,"id":2289,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":2,"sec_type":1,"seg_count":3,"serial_no":"3.2","title":"做空方：浑水","uuid":"058e2895e9f24c7c8ef1984191d2c0b0"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:25","entity_status":1,"has_new":0,"id":2294,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":2,"sec_type":1,"seg_count":1,"serial_no":"3.4.2","title":"汇生咨询","uuid":"384baec9cdc348928d3cee434e290ae0"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:42:35","entity_status":1,"has_new":0,"id":2290,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":3,"sec_type":1,"seg_count":3,"serial_no":"3.3","title":"审计方：安永","uuid":"0d1d0f9c945f4494bb8335f7757f941d"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:52:00","entity_status":1,"has_new":0,"id":2291,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":3,"sec_type":1,"seg_count":3,"serial_no":"2","title":"事件影响","uuid":"5ad49391946c43619804d854c62502d6"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:55:30","entity_status":1,"has_new":0,"id":2295,"is_default":0,"level":3,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"28a404f7552149b6860ee830ea2ca8ff","rank":3,"sec_type":1,"seg_count":0,"serial_no":"3.4.3","title":"久谦咨询","uuid":"24bef89ad54f403283b4db1576f1fb46"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:19:56","entity_status":1,"has_new":0,"id":2287,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":4,"sec_type":1,"seg_count":12,"serial_no":"3","title":"事件相关利益体","uuid":"0b24f0bf201a4f1d991b0629a750ee05"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T17:53:29","entity_status":1,"has_new":0,"id":2292,"is_default":0,"level":2,"outline_uuid":"3c782451d78b44b89d95204dc2590899","parent_uuid":"0b24f0bf201a4f1d991b0629a750ee05","rank":4,"sec_type":1,"seg_count":3,"serial_no":"3.4","title":"执行机构","uuid":"28a404f7552149b6860ee830ea2ca8ff"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T18:00:36","entity_status":1,"has_new":0,"id":2296,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":5,"sec_type":1,"seg_count":2,"serial_no":"4","title":"瑞幸股市动态","uuid":"f38aa7fc643d42079de685157a464c48"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T18:45:15","entity_status":1,"has_new":0,"id":2300,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":6,"sec_type":1,"seg_count":1,"serial_no":"5","title":"舆论趋势","uuid":"235a57f5a5294454a6fa7bd50f21d965"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"entity_created":"2020-05-27T19:23:14","entity_status":1,"has_new":0,"id":2304,"is_default":0,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":7,"sec_type":1,"seg_count":4,"serial_no":"6","title":"带来的启示","uuid":"1ac9b9225e8840c3afc597cecbc8abbb"},{"act_uuid":"0d10cca88721404c91b79dbd7a8f5f91","app_uuid":"6290fa1543894c209df6efa954bfb066","auto_archive":0,"description":"存放内容的默认章节","entity_created":"2020-05-27T16:54:07","entity_status":1,"has_new":0,"id":2283,"is_default":1,"level":1,"outline_uuid":"3c782451d78b44b89d95204dc2590899","rank":1,"sec_type":1,"seg_count":0,"serial_no":"7","title":"默认章节","uuid":"ecbb1903d30a4976a459f15dd5cfda44"}]
         * seg_count : 25
         * uuid : 3c782451d78b44b89d95204dc2590899
         * version : 1
         */

        private String             act_uuid;
        private String             app_uuid;
        private int                auto_serial_no;
        private String             entity_created;
        private int                entity_status;
        private String             hier_uuid;
        private int                id;
        private int                sec_count;
        private int                seg_count;
        private String             uuid;
        private int                version;
        private List<SectionsBean> sections;

        public String getAct_uuid() {
            return act_uuid;
        }

        public void setAct_uuid(String act_uuid) {
            this.act_uuid = act_uuid;
        }

        public String getApp_uuid() {
            return app_uuid;
        }

        public void setApp_uuid(String app_uuid) {
            this.app_uuid = app_uuid;
        }

        public int getAuto_serial_no() {
            return auto_serial_no;
        }

        public void setAuto_serial_no(int auto_serial_no) {
            this.auto_serial_no = auto_serial_no;
        }

        public String getEntity_created() {
            return entity_created;
        }

        public void setEntity_created(String entity_created) {
            this.entity_created = entity_created;
        }

        public int getEntity_status() {
            return entity_status;
        }

        public void setEntity_status(int entity_status) {
            this.entity_status = entity_status;
        }

        public String getHier_uuid() {
            return hier_uuid;
        }

        public void setHier_uuid(String hier_uuid) {
            this.hier_uuid = hier_uuid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSec_count() {
            return sec_count;
        }

        public void setSec_count(int sec_count) {
            this.sec_count = sec_count;
        }

        public int getSeg_count() {
            return seg_count;
        }

        public void setSeg_count(int seg_count) {
            this.seg_count = seg_count;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public List<SectionsBean> getSections() {
            return sections;
        }

        public void setSections(List<SectionsBean> sections) {
            this.sections = sections;
        }

        public static class SectionsBean {

            private boolean expand;// 是否展开
            private boolean select;// 是否选中

            public boolean isExpand() {
                return expand;
            }

            public boolean isSelect() {
                return select;
            }

            public void setSelect(boolean select) {
                this.select = select;
            }

            public void setExpand(boolean expand) {
                this.expand = expand;
            }




            private String             act_uuid;
            private String             app_uuid;
            private int                auto_archive;
            private String             entity_created;
            private int                entity_status;
            private int                has_new;
            private int                id;
            private int                is_default;
            private int                level;
            private String             outline_uuid;
            private String             parent_uuid;
            private int                rank;
            private int                sec_type;
            private int                seg_count;
            private String             serial_no;
            private String             title;
            private String             uuid;
            private String             description;
            private List<SectionsBean> childrenList;

            public List<SectionsBean> getChildrenList() {
                if (childrenList == null) {
                    return new ArrayList<>();
                }
                return childrenList;
            }

            public void setChildrenList(List<SectionsBean> childrenList) {
                this.childrenList = childrenList;
            }

            public String getAct_uuid() {
                return act_uuid;
            }

            public void setAct_uuid(String act_uuid) {
                this.act_uuid = act_uuid;
            }

            public String getApp_uuid() {
                return app_uuid;
            }

            public void setApp_uuid(String app_uuid) {
                this.app_uuid = app_uuid;
            }

            public int getAuto_archive() {
                return auto_archive;
            }

            public void setAuto_archive(int auto_archive) {
                this.auto_archive = auto_archive;
            }

            public String getEntity_created() {
                return entity_created;
            }

            public void setEntity_created(String entity_created) {
                this.entity_created = entity_created;
            }

            public int getEntity_status() {
                return entity_status;
            }

            public void setEntity_status(int entity_status) {
                this.entity_status = entity_status;
            }

            public int getHas_new() {
                return has_new;
            }

            public void setHas_new(int has_new) {
                this.has_new = has_new;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getOutline_uuid() {
                return outline_uuid;
            }

            public void setOutline_uuid(String outline_uuid) {
                this.outline_uuid = outline_uuid;
            }

            public String getParent_uuid() {
                return parent_uuid;
            }

            public void setParent_uuid(String parent_uuid) {
                this.parent_uuid = parent_uuid;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getSec_type() {
                return sec_type;
            }

            public void setSec_type(int sec_type) {
                this.sec_type = sec_type;
            }

            public int getSeg_count() {
                return seg_count;
            }

            public void setSeg_count(int seg_count) {
                this.seg_count = seg_count;
            }

            public String getSerial_no() {
                return serial_no;
            }

            public void setSerial_no(String serial_no) {
                this.serial_no = serial_no;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
