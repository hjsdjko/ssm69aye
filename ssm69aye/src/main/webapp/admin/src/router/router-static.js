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
    import discusschongwuxinxi from '@/views/modules/discusschongwuxinxi/list'
    import chongwuxinxi from '@/views/modules/chongwuxinxi/list'
    import fuwuxiangmu from '@/views/modules/fuwuxiangmu/list'
    import xiangmuyuyue from '@/views/modules/xiangmuyuyue/list'
    import storeup from '@/views/modules/storeup/list'
    import shangjia from '@/views/modules/shangjia/list'
    import chongwuyongpin from '@/views/modules/chongwuyongpin/list'
    import chongwufenlei from '@/views/modules/chongwufenlei/list'
    import xiangmuleixing from '@/views/modules/xiangmuleixing/list'
    import yonghu from '@/views/modules/yonghu/list'
    import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
    import discusschongwurizhi from '@/views/modules/discusschongwurizhi/list'
    import orders from '@/views/modules/orders/list'
    import chongwurizhi from '@/views/modules/chongwurizhi/list'
    import config from '@/views/modules/config/list'
    import discusschongwuyongpin from '@/views/modules/discusschongwuyongpin/list'
    import discussfuwuxiangmu from '@/views/modules/discussfuwuxiangmu/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
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
	path: '/discusschongwuxinxi',
        name: '宠物信息评论',
        component: discusschongwuxinxi
      }
      ,{
	path: '/chongwuxinxi',
        name: '宠物信息',
        component: chongwuxinxi
      }
      ,{
	path: '/fuwuxiangmu',
        name: '服务项目',
        component: fuwuxiangmu
      }
      ,{
	path: '/xiangmuyuyue',
        name: '项目预约',
        component: xiangmuyuyue
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/shangjia',
        name: '商家',
        component: shangjia
      }
      ,{
	path: '/chongwuyongpin',
        name: '宠物用品',
        component: chongwuyongpin
      }
      ,{
	path: '/chongwufenlei',
        name: '宠物分类',
        component: chongwufenlei
      }
      ,{
	path: '/xiangmuleixing',
        name: '项目类型',
        component: xiangmuleixing
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/shangpinfenlei',
        name: '商品分类',
        component: shangpinfenlei
      }
      ,{
	path: '/discusschongwurizhi',
        name: '宠物日志评论',
        component: discusschongwurizhi
      }
      ,{
        path: '/orders/:status',
        name: '订单管理',
        component: orders
      }
      ,{
	path: '/chongwurizhi',
        name: '宠物日志',
        component: chongwurizhi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/discusschongwuyongpin',
        name: '宠物用品评论',
        component: discusschongwuyongpin
      }
      ,{
	path: '/discussfuwuxiangmu',
        name: '服务项目评论',
        component: discussfuwuxiangmu
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
    name: '首页',
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

export default router;
