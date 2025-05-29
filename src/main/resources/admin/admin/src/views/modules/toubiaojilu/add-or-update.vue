<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","borderRadius":"6px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="100px"
		>
			<template >
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="投标单号" prop="toubiaodanhao">
					<el-input v-model="ruleForm.toubiaodanhao" placeholder="投标单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.toubiaodanhao" label="投标单号" prop="toubiaodanhao">
					<el-input v-model="ruleForm.toubiaodanhao" placeholder="投标单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="招标名称" prop="zhaobiaomingcheng">
					<el-input v-model="ruleForm.zhaobiaomingcheng" placeholder="招标名称" clearable  :readonly="ro.zhaobiaomingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="招标名称" prop="zhaobiaomingcheng">
					<el-input v-model="ruleForm.zhaobiaomingcheng" placeholder="招标名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="标书价格" prop="biaoshujiage">
					<el-input v-model="ruleForm.biaoshujiage" placeholder="标书价格" clearable  :readonly="ro.biaoshujiage"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="标书价格" prop="biaoshujiage">
					<el-input v-model="ruleForm.biaoshujiage" placeholder="标书价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="招标单位" prop="zhaobiaodanwei">
					<el-input v-model="ruleForm.zhaobiaodanwei" placeholder="招标单位" clearable  :readonly="ro.zhaobiaodanwei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="招标单位" prop="zhaobiaodanwei">
					<el-input v-model="ruleForm.zhaobiaodanwei" placeholder="招标单位" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="投标日期" prop="toubiaoriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.toubiaoriqi" 
						type="date"
						:readonly="ro.toubiaoriqi"
						placeholder="投标日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.toubiaoriqi" label="投标日期" prop="toubiaoriqi">
					<el-input v-model="ruleForm.toubiaoriqi" placeholder="投标日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.toubiaowenjian" label="投标文件" prop="toubiaowenjian">
					<file-upload
						tip="点击上传投标文件"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.toubiaowenjian?ruleForm.toubiaowenjian:''"
						@change="toubiaowenjianUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else-if="ruleForm.toubiaowenjian" label="投标文件" prop="toubiaowenjian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 25px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#93C7B3","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.toubiaowenjian)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else-if="!ruleForm.toubiaowenjian" label="投标文件" prop="toubiaowenjian">
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 25px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"30px","background":"#93C7B3","width":"auto","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="评标状态" prop="pingbiaozhuangtai">
					<el-select :disabled="ro.pingbiaozhuangtai" v-model="ruleForm.pingbiaozhuangtai" placeholder="请选择评标状态" >
						<el-option
							v-for="(item,index) in pingbiaozhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="评标状态" prop="pingbiaozhuangtai">
					<el-input v-model="ruleForm.pingbiaozhuangtai"
						placeholder="评标状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="投标单位" prop="toubiaodanwei">
					<el-input v-model="ruleForm.toubiaodanwei" placeholder="投标单位" clearable  :readonly="ro.toubiaodanwei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="投标单位" prop="toubiaodanwei">
					<el-input v-model="ruleForm.toubiaodanwei" placeholder="投标单位" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="textarea" v-if="type!='info'" label="投标内容" prop="toubiaoneirong">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="投标内容"
					  v-model="ruleForm.toubiaoneirong" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else-if="ruleForm.toubiaoneirong" label="投标内容" prop="toubiaoneirong">
					<span :style='{"fontSize":"14px","lineHeight":"40px","color":"#000","fontWeight":"500","display":"inline-block"}'>{{ruleForm.toubiaoneirong}}</span>
				</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"30px","background":"#93C7B3","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"30px","background":"#93C7B3","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"30px","background":"#93C7B3","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
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
				shhf: '',
			},
		
			pingbiaozhuangtaiOptions: [],
			
			rules: {
				toubiaodanhao: [
				],
				zhaobiaomingcheng: [
				],
				biaoshujiage: [
					{ validator: validateIntNumber, trigger: 'blur' },
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
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
		this.ruleForm.toubiaoriqi = this.getCurDate()
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
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
				








				this.ruleForm.pingbiaozhuangtai='未评标'






			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(this.$storage.get("role")!="管理员") {
						this.ro.toubiaodanhao = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.zhaobiaomingcheng = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.biaoshujiage = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.zhaobiaodanwei = true;
					}
					if(this.$storage.get("role")!="管理员") {
						this.ro.pingbiaozhuangtai = true;
					}
					if(json.toubiaodanwei!=''&&json.toubiaodanwei && this.$storage.get("role")!="管理员"){
						this.ruleForm.toubiaodanwei = json.toubiaodanwei
						this.ro.toubiaodanwei = true;
					}
					if(json.lianxidianhua!=''&&json.lianxidianhua && this.$storage.get("role")!="管理员"){
						this.ruleForm.lianxidianhua = json.lianxidianhua
						this.ro.lianxidianhua = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.pingbiaozhuangtaiOptions = "已评标,未评标".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `toubiaojilu/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {












	if(this.ruleForm.toubiaowenjian!=null) {
		this.ruleForm.toubiaowenjian = this.ruleForm.toubiaowenjian.replace(new RegExp(this.$base.url,"g"),"");
	}

















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "toubiaojilu/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `toubiaojilu/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.toubiaojiluCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `toubiaojilu/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.toubiaojiluCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
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
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.toubiaojiluCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    toubiaowenjianUploadChange(fileUrls) {
	    this.ruleForm.toubiaowenjian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 100px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
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
	  	  border: 1px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px dashed #797979;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #797979;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #797979;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
