<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230106/58eb0ca95fe94ea3912632230dc4f6d4.jpg) no-repeat center top /  100% 100%,#fff","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"10px 80px 20px  80px","boxShadow":"0 0px 0px rgba(0, 0, 0, .1)","margin":"0 auto","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","borderRadius":"0px","background":"#fff","borderWidth":"8px 16px 8px 16px","width":"800px","position":"relative","borderStyle":"solid","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 10px 0","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","textAlign":"center","borderWidth":"8px 16px 8px 16px","width":"100%","lineHeight":"44px","fontSize":"16px","borderStyle":"solid"}'>基于BS招投标管理系统 注册</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="zhaobiaodanwei">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>招标单位：</div>
				<el-input v-model="registerForm.zhaobiaodanwei"  placeholder="请输入招标单位" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="lianxiren">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系人：</div>
				<el-input v-model="registerForm.lianxiren"  placeholder="请输入联系人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="zhaobiaozige">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>招标资格：</div>
                <file-upload
					tip="点击上传招标资格"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.zhaobiaozige?registerForm.zhaobiaozige:''"
					@change="zhaobiaodanweizhaobiaozigeUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="zixundianhua">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>咨询电话：</div>
				<el-input v-model="registerForm.zixundianhua"  placeholder="请输入咨询电话" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='zhaobiaodanwei'" prop="bangongdizhi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>办公地址：</div>
				<el-input v-model="registerForm.bangongdizhi"  placeholder="请输入办公地址" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="zhuanjiaxingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>专家姓名：</div>
				<el-input v-model="registerForm.zhuanjiaxingming"  placeholder="请输入专家姓名" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>头像：</div>
                <file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="pingbiaozhuanjiatouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="nianling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>年龄：</div>
				<el-input v-model="registerForm.nianling"  placeholder="请输入年龄" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="zhicheng">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>职称：</div>
				<el-input v-model="registerForm.zhicheng"  placeholder="请输入职称" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='pingbiaozhuanjia'" prop="lianxifangshi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系方式：</div>
				<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="toubiaodanwei">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>投标单位：</div>
				<el-input v-model="registerForm.toubiaodanwei"  placeholder="请输入投标单位" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>密码：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>确认密码：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="lianxiren">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系人：</div>
				<el-input v-model="registerForm.lianxiren"  placeholder="请输入联系人" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="toubiaojibie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>投标级别：</div>
                <el-select v-model="registerForm.toubiaojibie" placeholder="请选择投标级别" disabled>
                  <el-option
                      v-for="(item,index) in toubiaodanweitoubiaojibieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="bangongdizhi">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>办公地址：</div>
				<el-input v-model="registerForm.bangongdizhi"  placeholder="请输入办公地址" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="jingyingfanwei">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>经营范围：</div>
				<el-input v-model="registerForm.jingyingfanwei"  placeholder="请输入经营范围" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='toubiaodanwei'" prop="lianxidianhua">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>联系电话：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="请输入联系电话" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","display":"inline-block","outline":"none","borderRadius":"8px","background":"#fdf6f6","borderWidth":"8px 16px 8px 16px","width":"120px","fontSize":"16px","borderStyle":"solid","height":"50px"}' type="primary" @click="submitForm('registerForm')">注册</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","display":"inline-block","outline":"none","borderRadius":"8px","background":"#fdf6f6","borderWidth":"8px 16px 8px 16px","width":"120px","fontSize":"16px","borderStyle":"solid","height":"50px"}' @click="resetForm('registerForm')">重置</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#333","display":"inline-block","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">已有账户登录</router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                toubiaojibie: '一级',
            },
			rules: {},
            toubiaodanweitoubiaojibieOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('zhaobiaodanwei' == this.tableName) {
        this.rules.zhaobiaodanwei = [{ required: true, message: '请输入招标单位', trigger: 'blur' }];
      }
      if ('zhaobiaodanwei' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('zhaobiaodanwei' == this.tableName) {
        this.rules.zixundianhua = [{ required: true, validator: this.$validate.isPhone, trigger: 'blur' }];
      }
      if ('pingbiaozhuanjia' == this.tableName) {
        this.rules.zhuanjiaxingming = [{ required: true, message: '请输入专家姓名', trigger: 'blur' }];
      }
      if ('pingbiaozhuanjia' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
      if ('pingbiaozhuanjia' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
      if ('pingbiaozhuanjia' == this.tableName) {
        this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('toubiaodanwei' == this.tableName) {
        this.rules.toubiaodanwei = [{ required: true, message: '请输入投标单位', trigger: 'blur' }];
      }
      if ('toubiaodanwei' == this.tableName) {
        this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
      }
        this.toubiaodanweitoubiaojibieOptions = "一级,二级,三级".split(',');
      if ('toubiaodanwei' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      zhaobiaodanweizhaobiaozigeUploadChange(fileUrls) {
          this.registerForm.zhaobiaozige = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      pingbiaozhuanjiatouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`zhaobiaodanwei` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`pingbiaozhuanjia` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
               if(`toubiaodanwei` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`两次密码输入不一致`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: '注册成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230106/58eb0ca95fe94ea3912632230dc4f6d4.jpg) no-repeat center top /  100% 100%,#fff;

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
