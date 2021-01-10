import Vue from 'vue'
import VueRouter from 'vue-router'
import Event from '@/components/user/Event'
import PageNotFound from '@/components/PageNotFound'

Vue.use(VueRouter)

export default new VueRouter({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Event",
      component: Event
    },
    {
      path: "*",
      component: PageNotFound
    }
  ]
});
