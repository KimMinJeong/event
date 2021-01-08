import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/web/Index'
import IndexM from '../components/mobile/Index'

Vue.use(Router)
const  routes = [
  {
    path: '/',
    name: 'Root',
    component: {
      default: Index,
      mobile: IndexM
    }
  }
]

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
