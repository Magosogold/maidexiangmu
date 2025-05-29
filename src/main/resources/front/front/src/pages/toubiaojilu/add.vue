<template>
<div :style='{"width":"90%","padding":"30px 0px 40px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,.0)"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="投标单号" prop="toubiaodanhao">
              <el-input v-model="ruleForm.toubiaodanhao" placeholder="投标单号" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标名称" prop="zhaobiaomingcheng">
            <el-input v-model="ruleForm.zhaobiaomingcheng" 
                placeholder="招标名称" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="标书价格" prop="biaoshujiage">
            <el-input v-model="ruleForm.biaoshujiage" 
                placeholder="标书价格" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="招标单位" prop="zhaobiaodanwei">
            <el-input v-model="ruleForm.zhaobiaodanwei" 
                placeholder="招标单位" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="投标日期" prop="toubiaoriqi" >
              <el-date-picker
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.toubiaoriqi" 
                  type="date"
                  placeholder="投标日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="投标文件" prop="toubiaowenjian">
            <file-upload
            tip="点击上传投标文件"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.toubiaowenjian?ruleForm.toubiaowenjian:''"
            @change="toubiaowenjianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="评标状态" prop="pingbiaozhuangtai">
            <el-select v-model="ruleForm.pingbiaozhuangtai" placeholder="请选择评标状态" disabled >
              <el-option
                  v-for="(item,index) in pingbiaozhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="投标单位" prop="toubiaodanwei">
            <el-input v-model="ruleForm.toubiaodanwei" 
                placeholder="投标单位" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="联系电话" prop="lianxidianhua">
            <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="投标内容" prop="toubiaoneirong">
            <el-input
              type="textarea"
              :rows="8"
              placeholder="投标内容"
              v-model="ruleForm.toubiaoneirong">
            </el-input>
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
            toubiaodanhao : false,
            zhaobiaomingcheng : false,
            biaoshujiage : false,
            zhaobiaodanwei : false,
            toubiaoriqi : false,
            toubiaowenjian : false,
            toubiaoneirong : false,
            pingbiaozhuangtai : false,
            toubiaodanwei : false,
            lianxidianhua : false,
            crossuserid : false,
            crossrefid : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          toubiaodanhao: this.getUUID(),
          zhaobiaomingcheng: '',
          biaoshujiage: '',
          zhaobiaodanwei: '',
          toubiaoriqi: '',
          toubiaowenjian: '',
          toubiaoneirong: '',
          pingbiaozhuangtai: '未评标',
          toubiaodanwei: '',
          lianxidianhua: '',
          crossuserid: '',
          crossrefid: '',
        },
        pingbiaozhuangtaiOptions: [],
        rules: {
          toubiaodanhao: [
          ],
          zhaobiaomingcheng: [
          ],
          biaoshujiage: [
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
          zhaobiaodanwei: [
          ],
          toubiaoriqi: [
          ],
          toubiaowenjian: [
          ],
          toubiaoneirong: [
          ],
          pingbiaozhuangtai: [
          ],
          toubiaodanwei: [
          ],
          lianxidianhua: [
          ],
          crossuserid: [
          ],
          crossrefid: [
          ],
          sfsh: [
          ],
          shhf: [
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
      this.ruleForm.toubiaoriqi = this.getCurDate()
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
            if(o=='toubiaodanhao'){
              this.ruleForm.toubiaodanhao = obj[o];
              this.ro.toubiaodanhao = true;
              continue;
            }
            if(o=='zhaobiaomingcheng'){
              this.ruleForm.zhaobiaomingcheng = obj[o];
              this.ro.zhaobiaomingcheng = true;
              continue;
            }
            if(o=='biaoshujiage'){
              this.ruleForm.biaoshujiage = obj[o];
              this.ro.biaoshujiage = true;
              continue;
            }
            if(o=='zhaobiaodanwei'){
              this.ruleForm.zhaobiaodanwei = obj[o];
              this.ro.zhaobiaodanwei = true;
              continue;
            }
            if(o=='toubiaoriqi'){
              this.ruleForm.toubiaoriqi = obj[o];
              this.ro.toubiaoriqi = true;
              continue;
            }
            if(o=='toubiaowenjian'){
              this.ruleForm.toubiaowenjian = obj[o];
              this.ro.toubiaowenjian = true;
              continue;
            }
            if(o=='toubiaoneirong'){
              this.ruleForm.toubiaoneirong = obj[o];
              this.ro.toubiaoneirong = true;
              continue;
            }
            if(o=='pingbiaozhuangtai'){
              this.ruleForm.pingbiaozhuangtai = obj[o];
              this.ro.pingbiaozhuangtai = true;
              continue;
            }
            if(o=='toubiaodanwei'){
              this.ruleForm.toubiaodanwei = obj[o];
              this.ro.toubiaodanwei = true;
              continue;
            }
            if(o=='lianxidianhua'){
              this.ruleForm.lianxidianhua = obj[o];
              this.ro.lianxidianhua = true;
              continue;
            }
            if(o=='crossuserid'){
              this.ruleForm.crossuserid = obj[o];
              this.ro.crossuserid = true;
              continue;
            }
            if(o=='crossrefid'){
              this.ruleForm.crossrefid = obj[o];
              this.ro.crossrefid = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if(json.toubiaodanwei!=''&&json.toubiaodanwei){
                this.ruleForm.toubiaodanwei = json.toubiaodanwei
            }
            if(json.lianxidianhua!=''&&json.lianxidianhua){
                this.ruleForm.lianxidianhua = json.lianxidianhua
            }
          }
        });
        this.pingbiaozhuangtaiOptions = "已评标,未评标".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('toubiaojilu/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('toubiaojilu/list', {
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


                          this.$http.post('toubiaojilu/add', this.ruleForm).then(res => {
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


                  this.$http.post('toubiaojilu/add', this.ruleForm).then(res => {
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
      toubiaowenjianUploadChange(fileUrls) {
          this.ruleForm.toubiaowenjian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
