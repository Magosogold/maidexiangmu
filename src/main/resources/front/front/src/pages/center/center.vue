<template>
<div class="center-preview" :style='{"width":"90%","margin":"10px auto","position":"relative","background":"none"}'>
	<div class="title" :style='{"margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center","background":"none"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"background":"none"}' @tab-click="handleClick">
      <el-tab-pane label="个人中心">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="120px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="招标单位" prop="zhaobiaodanwei">
            <el-input v-model="sessionForm.zhaobiaodanwei" placeholder="招标单位" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="联系人" prop="lianxiren">
            <el-input v-model="sessionForm.lianxiren" placeholder="联系人" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="招标资格">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="zhaobiaodanweizhaobiaozigeHandleAvatarSuccess">
              <img :style='{"border":"1px solid #d2e5fd","cursor":"pointer","color":"#333","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.zhaobiaozige" :src="baseUrl + sessionForm.zhaobiaozige" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="咨询电话" prop="zixundianhua">
            <el-input v-model="sessionForm.zixundianhua" placeholder="咨询电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='zhaobiaodanwei'" label="办公地址" prop="bangongdizhi">
            <el-input v-model="sessionForm.bangongdizhi" placeholder="办公地址" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="专家姓名" prop="zhuanjiaxingming">
            <el-input v-model="sessionForm.zhuanjiaxingming" placeholder="专家姓名" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="头像">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="pingbiaozhuanjiatouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #d2e5fd","cursor":"pointer","color":"#333","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="年龄" prop="nianling">
            <el-input v-model="sessionForm.nianling" placeholder="年龄" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="职称" prop="zhicheng">
            <el-input v-model="sessionForm.zhicheng" placeholder="职称" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='pingbiaozhuanjia'" label="联系方式" prop="lianxifangshi">
            <el-input v-model="sessionForm.lianxifangshi" placeholder="联系方式" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="投标单位" prop="toubiaodanwei">
            <el-input v-model="sessionForm.toubiaodanwei" placeholder="投标单位" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="密码" prop="mima">
            <el-input type="password" v-model="sessionForm.mima" placeholder="密码"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="联系人" prop="lianxiren">
            <el-input v-model="sessionForm.lianxiren" placeholder="联系人" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="投标级别">
            <el-select v-model="sessionForm.toubiaojibie" placeholder="请选择投标级别" disabled>
              <el-option v-for="(item, index) in dynamicProp.toubiaojibie" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="办公地址" prop="bangongdizhi">
            <el-input v-model="sessionForm.bangongdizhi" placeholder="办公地址" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="经营范围" prop="jingyingfanwei">
            <el-input v-model="sessionForm.jingyingfanwei" placeholder="经营范围" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='toubiaodanwei'" label="联系电话" prop="lianxidianhua">
            <el-input v-model="sessionForm.lianxidianhua" placeholder="联系电话" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"#f8e0e0","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">更新信息</el-button>
            <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"4px","background":"#d6d6d6","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">退出登录</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="用户充值" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="充值金额" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="充值金额"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">取 消</el-button>
            <el-button type="primary" @click="chongzhi">确认充值</el-button>
          </div>
        </el-dialog>
        <el-dialog title="会员购买" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="会员卡" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/年"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="微信支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">微信支付</span>
                </el-radio>
                <el-radio label="支付宝支付">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">支付宝支付</span>
                </el-radio>
                <el-radio label="中国建设银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国农业银行支付">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="中国银行支付">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="交通银行支付">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">取 消</el-button>
            <el-button type="primary" @click="chongzhivip">确认支付</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="我的收藏"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: '个人中心',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'zhaobiaodanwei', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxiren', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'zhaobiaozige', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'zixundianhua', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'bangongdizhi', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'sfsh', null);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'shhf', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'zhuanjiaxingming', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'nianling', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'zhicheng', null);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxifangshi', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'toubiaodanwei', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'mima', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxiren', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'toubiaojibie', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'bangongdizhi', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'jingyingfanwei', null);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.sessionForm, 'lianxidianhua', null);
      }

      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'zhaobiaodanwei', [{ required: true, message: '请输入招标单位', trigger: 'blur' }]);
      }
      if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('zhaobiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'zixundianhua', [{ required: false, validator: this.$validate.isPhone, trigger: 'blur' }]);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.rules, 'zhuanjiaxingming', [{ required: true, message: '请输入专家姓名', trigger: 'blur' }]);
      }
      if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.rules, 'nianling', [{ required: false, validator: this.$validate.isIntNumer, trigger: 'blur' }]);
      }
			if ('pingbiaozhuanjia' == this.userTableName) {
        this.$set(this.rules, 'lianxifangshi', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'toubiaodanwei', [{ required: true, message: '请输入投标单位', trigger: 'blur' }]);
      }
      if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'mima', [{ required: true, message: '请输入密码', trigger: 'blur' }]);
      }
			if ('toubiaodanwei' == this.userTableName) {
        this.$set(this.rules, 'lianxidianhua', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('toubiaodanwei' == this.userTableName) {
          this.dynamicProp.toubiaojibie = '一级,二级,三级'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: '更新成功',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      zhaobiaodanweizhaobiaozigeHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('zhaobiaodanwei' == this.userTableName) {
            this.sessionForm.zhaobiaozige = 'upload/' + res.file;
          }
        }
      },
      pingbiaozhuanjiatouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('pingbiaozhuanjia' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: '请输入充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: '请输入正确的充值金额',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择充值方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseInt(this.sessionForm.money) + parseInt(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '充值成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: '请选择支付方式',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == '是') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "是"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: '会员购买成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case '个人中心':
            tab.$router.push('/index/center');
            break;
          case '我的收藏':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: '登出成功',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 00px 0px 0px 50px;
	margin: 20px 0 0;
	background: rgba(255,255,255,.0);
	width: 340px;
	border-color: #eee;
	border-width: 0;
	position: relative;
	float: right;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	border: 1px solid #ddd;
  	padding: 0 10px;
  	margin: 0 0 24px;
  	color: #333;
  	background: #f5f5f5;
  	font-weight: 500;
  	width: 250px;
  	font-size: 14px;
  	line-height: 50px;
  	position: relative;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border: 1px solid #fff;
  	padding: 0 10px;
  	color: #fff;
  	background: linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	position: relative;
  	text-align: center;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border: 1px solid #fff;
  	padding: 0 10px;
  	color: #fff;
  	background: linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 50px;
  	position: relative;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	border: 10px inset #98c6e2;
  	padding: 20px 0;
  	background: #fff;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 120px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 120px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #333;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px solid #d2e5fd;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #333;
  	width: 100px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: 100px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
