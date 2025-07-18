import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import guidangbaocun from '@/views/modules/guidangbaocun/list'
    import aboutus from '@/views/modules/aboutus/list'
    import zhaobiaodanwei from '@/views/modules/zhaobiaodanwei/list'
    import toubiaojilu from '@/views/modules/toubiaojilu/list'
    import systemintro from '@/views/modules/systemintro/list'
    import toubiaodanwei from '@/views/modules/toubiaodanwei/list'
    import zhaobiaoxiangmu from '@/views/modules/zhaobiaoxiangmu/list'
    import pingbiaojilu from '@/views/modules/pingbiaojilu/list'
    import config from '@/views/modules/config/list'
    import pingbiaozhuanjia from '@/views/modules/pingbiaozhuanjia/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/guidangbaocun',
        name: '归档保存',
        component: guidangbaocun
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/zhaobiaodanwei',
        name: '招标单位',
        component: zhaobiaodanwei
      }
      ,{
	path: '/toubiaojilu',
        name: '投标记录',
        component: toubiaojilu
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/toubiaodanwei',
        name: '投标单位',
        component: toubiaodanwei
      }
      ,{
	path: '/zhaobiaoxiangmu',
        name: '招标项目',
        component: zhaobiaoxiangmu
      }
      ,{
	path: '/pingbiaojilu',
        name: '评标记录',
        component: pingbiaojilu
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/pingbiaozhuanjia',
        name: '评标专家',
        component: pingbiaozhuanjia
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
