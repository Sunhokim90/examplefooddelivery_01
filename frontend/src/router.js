
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import OwnerManager from "./components/listers/OwnerCards"
import OwnerDetail from "./components/listers/OwnerDetail"

import RiderManager from "./components/listers/RiderCards"
import RiderDetail from "./components/listers/RiderDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/owners',
                name: 'OwnerManager',
                component: OwnerManager
            },
            {
                path: '/owners/:id',
                name: 'OwnerDetail',
                component: OwnerDetail
            },

            {
                path: '/riders',
                name: 'RiderManager',
                component: RiderManager
            },
            {
                path: '/riders/:id',
                name: 'RiderDetail',
                component: RiderDetail
            },




    ]
})
