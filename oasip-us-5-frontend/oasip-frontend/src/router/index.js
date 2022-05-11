import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Create from '../views/Create.vue'

const history = createWebHistory(import.meta.env.BASE_URL)
const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/create', name: 'Create', component: Create },
]

const router = createRouter({ history, routes })
export default router
