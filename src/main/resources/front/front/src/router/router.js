import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import zhaobiaodanweiList from '../pages/zhaobiaodanwei/list'
import zhaobiaodanweiDetail from '../pages/zhaobiaodanwei/detail'
import zhaobiaodanweiAdd from '../pages/zhaobiaodanwei/add'
import pingbiaozhuanjiaList from '../pages/pingbiaozhuanjia/list'
import pingbiaozhuanjiaDetail from '../pages/pingbiaozhuanjia/detail'
import pingbiaozhuanjiaAdd from '../pages/pingbiaozhuanjia/add'
import toubiaodanweiList from '../pages/toubiaodanwei/list'
import toubiaodanweiDetail from '../pages/toubiaodanwei/detail'
import toubiaodanweiAdd from '../pages/toubiaodanwei/add'
import zhaobiaoxiangmuList from '../pages/zhaobiaoxiangmu/list'
import zhaobiaoxiangmuDetail from '../pages/zhaobiaoxiangmu/detail'
import zhaobiaoxiangmuAdd from '../pages/zhaobiaoxiangmu/add'
import toubiaojiluList from '../pages/toubiaojilu/list'
import toubiaojiluDetail from '../pages/toubiaojilu/detail'
import toubiaojiluAdd from '../pages/toubiaojilu/add'
import pingbiaojiluList from '../pages/pingbiaojilu/list'
import pingbiaojiluDetail from '../pages/pingbiaojilu/detail'
import pingbiaojiluAdd from '../pages/pingbiaojilu/add'
import guidangbaocunList from '../pages/guidangbaocun/list'
import guidangbaocunDetail from '../pages/guidangbaocun/detail'
import guidangbaocunAdd from '../pages/guidangbaocun/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'zhaobiaodanwei',
					component: zhaobiaodanweiList
				},
				{
					path: 'zhaobiaodanweiDetail',
					component: zhaobiaodanweiDetail
				},
				{
					path: 'zhaobiaodanweiAdd',
					component: zhaobiaodanweiAdd
				},
				{
					path: 'pingbiaozhuanjia',
					component: pingbiaozhuanjiaList
				},
				{
					path: 'pingbiaozhuanjiaDetail',
					component: pingbiaozhuanjiaDetail
				},
				{
					path: 'pingbiaozhuanjiaAdd',
					component: pingbiaozhuanjiaAdd
				},
				{
					path: 'toubiaodanwei',
					component: toubiaodanweiList
				},
				{
					path: 'toubiaodanweiDetail',
					component: toubiaodanweiDetail
				},
				{
					path: 'toubiaodanweiAdd',
					component: toubiaodanweiAdd
				},
				{
					path: 'zhaobiaoxiangmu',
					component: zhaobiaoxiangmuList
				},
				{
					path: 'zhaobiaoxiangmuDetail',
					component: zhaobiaoxiangmuDetail
				},
				{
					path: 'zhaobiaoxiangmuAdd',
					component: zhaobiaoxiangmuAdd
				},
				{
					path: 'toubiaojilu',
					component: toubiaojiluList
				},
				{
					path: 'toubiaojiluDetail',
					component: toubiaojiluDetail
				},
				{
					path: 'toubiaojiluAdd',
					component: toubiaojiluAdd
				},
				{
					path: 'pingbiaojilu',
					component: pingbiaojiluList
				},
				{
					path: 'pingbiaojiluDetail',
					component: pingbiaojiluDetail
				},
				{
					path: 'pingbiaojiluAdd',
					component: pingbiaojiluAdd
				},
				{
					path: 'guidangbaocun',
					component: guidangbaocunList
				},
				{
					path: 'guidangbaocunDetail',
					component: guidangbaocunDetail
				},
				{
					path: 'guidangbaocunAdd',
					component: guidangbaocunAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
