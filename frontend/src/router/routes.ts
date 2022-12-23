// @ts-nocheck
import { RouteRecordRaw } from "vue-router"
import Home from "@/views/Home.vue"
import Employees from '@/views/Teacher.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: () => import('@/views/List.vue'),
  },
  {
    path: '/add',
    component: () => import('@/views/AddCustomer.vue'),
  },
  {
    path: '/edit/:id',
    component: () => import('@/views/EditCustomer.vue'),
    props: (route) => {
      const id = Number.parseInt(route.params.id);
      return { id }
    },


  },
]

export default routes
