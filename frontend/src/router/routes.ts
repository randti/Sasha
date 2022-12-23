// @ts-nocheck
import { RouteRecordRaw } from "vue-router"
import Home from "@/views/Home.vue"
import Employees from '@/views/Teacher.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'list',
    alias: '/list',
    component: () => import('@/views/List.vue'),
  },
  {
    path: '/add',
    component: () => import('@/views/Add.vue'),
  },
  {
    path: '/books/:id',
    component: () => import('@/views/Edit.vue'),
    props: (route) => {
      const id = Number.parseInt(route.params.id);
      return { id }
    },


  },
]

export default routes
