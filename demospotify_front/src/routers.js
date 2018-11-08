import Search from './components/Search.vue'
import Library from './components/Library.vue'


const routers = [
  {
    path: '/search',
    name: 'Search',
    component: Search
  },
  {
    path: '/',
    component: Search
  },
  {
    path: '/library',
	name: 'Library',
    component: Library
  },
]
export default routers