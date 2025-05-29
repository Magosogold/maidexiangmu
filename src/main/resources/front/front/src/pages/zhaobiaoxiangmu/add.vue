<template>
<div :style='{"width":"90%","padding":"30px 0px 40px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,.0)"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标名称" prop="zhaobiaomingcheng">
            <el-input v-model="ruleForm.zhaobiaomingcheng" 
                placeholder="招标名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="项目图片" v-if="type!='cross' || (type=='cross' && !ro.xiangmutupian)" prop="xiangmutupian">
            <file-upload
            tip="点击上传项目图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.xiangmutupian?ruleForm.xiangmutupian:''"
            @change="xiangmutupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' class="upload" v-else label="项目图片" prop="xiangmutupian">
                <img v-if="ruleForm.xiangmutupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.xiangmutupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.xiangmutupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标文件" prop="zhaobiaowenjian">
            <file-upload
            tip="点击上传招标文件"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.zhaobiaowenjian?ruleForm.zhaobiaowenjian:''"
            @change="zhaobiaowenjianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="标书价格" prop="biaoshujiage">
            <el-input v-model="ruleForm.biaoshujiage" 
                placeholder="标书价格" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="补充说明" prop="buchongshuoming">
            <el-input v-model="ruleForm.buchongshuoming" 
                placeholder="补充说明" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="发布日期" prop="faburiqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.faburiqi" 
                  type="date"
                  placeholder="发布日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标单位" prop="zhaobiaodanwei">
            <el-input v-model="ruleForm.zhaobiaodanwei" 
                placeholder="招标单位" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="咨询电话" prop="zixundianhua">
            <el-input v-model="ruleForm.zixundianhua" 
                placeholder="咨询电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="倒计结束时间" prop="reversetime" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.reversetime" 
                  type="datetime"
                  placeholder="倒计结束时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标内容" prop="zhaobiaoneirong">
            <editor 
                :style='{"border":"1px solid #d2e5fd","minHeight":"300px","padding":"0","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.zhaobiaoneirong" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"5px outset #6eb9ff","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"46px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"5px outset #d1d1d1","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"46px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            zhaobiaomingcheng : false,
            xiangmutupian : false,
            zhaobiaowenjian : false,
            biaoshujiage : false,
            buchongshuoming : false,
            zhaobiaoneirong : false,
            faburiqi : false,
            zhaobiaodanwei : false,
            zixundianhua : false,
            sfsh : false,
            shhf : false,
            reversetime : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          zhaobiaomingcheng: '',
          xiangmutupian: '',
          zhaobiaowenjian: '',
          biaoshujiage: '',
          buchongshuoming: '',
          zhaobiaoneirong: '',
          faburiqi: '',
          zhaobiaodanwei: '',
          zixundianhua: '',
          reversetime: '',
        },
        rules: {
          zhaobiaomingcheng: [
            { required: true, message: '招标名称不能为空', trigger: 'blur' },
          ],
          xiangmutupian: [
          ],
          zhaobiaowenjian: [
          ],
          biaoshujiage: [
            { required: true, message: '标书价格不能为空', trigger: 'blur' },
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          buchongshuoming: [
          ],
          zhaobiaoneirong: [
          ],
          faburiqi: [
          ],
          zhaobiaodanwei: [
          ],
          zixundianhua: [
            { validator: this.$validate.isPhone, trigger: 'blur' },
          ],
          sfsh: [
          ],
          shhf: [
          ],
          reversetime: [
          ],
        },
      };
    },
    computed: {



    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.faburiqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='zhaobiaomingcheng'){
              this.ruleForm.zhaobiaomingcheng = obj[o];
              this.ro.zhaobiaomingcheng = true;
              continue;
            }
            if(o=='xiangmutupian'){
              this.ruleForm.xiangmutupian = obj[o].split(",")[0];
              this.ro.xiangmutupian = true;
              continue;
            }
            if(o=='zhaobiaowenjian'){
              this.ruleForm.zhaobiaowenjian = obj[o];
              this.ro.zhaobiaowenjian = true;
              continue;
            }
            if(o=='biaoshujiage'){
              this.ruleForm.biaoshujiage = obj[o];
              this.ro.biaoshujiage = true;
              continue;
            }
            if(o=='buchongshuoming'){
              this.ruleForm.buchongshuoming = obj[o];
              this.ro.buchongshuoming = true;
              continue;
            }
            if(o=='zhaobiaoneirong'){
              this.ruleForm.zhaobiaoneirong = obj[o];
              this.ro.zhaobiaoneirong = true;
              continue;
            }
            if(o=='faburiqi'){
              this.ruleForm.faburiqi = obj[o];
              this.ro.faburiqi = true;
              continue;
            }
            if(o=='zhaobiaodanwei'){
              this.ruleForm.zhaobiaodanwei = obj[o];
              this.ro.zhaobiaodanwei = true;
              continue;
            }
            if(o=='zixundianhua'){
              this.ruleForm.zixundianhua = obj[o];
              this.ro.zixundianhua = true;
              continue;
            }
            if(o=='reversetime'){
              this.ruleForm.reversetime = obj[o];
              this.ro.reversetime = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if(json.zhaobiaodanwei!=''&&json.zhaobiaodanwei){
                this.ruleForm.zhaobiaodanwei = json.zhaobiaodanwei
            }
            if(json.zixundianhua!=''&&json.zixundianhua){
                this.ruleForm.zixundianhua = json.zixundianhua
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('zhaobiaoxiangmu/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('zhaobiaoxiangmu/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('zhaobiaoxiangmu/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('zhaobiaoxiangmu/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      xiangmutupianUploadChange(fileUrls) {
          this.ruleForm.xiangmutupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      zhaobiaowenjianUploadChange(fileUrls) {
          this.ruleForm.zhaobiaowenjian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #3d74c0;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
