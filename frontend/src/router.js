
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);



import FileInfoView from "./components/FileInfoView"
import FileInfoViewDetail from "./components/FileInfoViewDetail"
import DriveFileManager from "./components/listers/DriveFileCards"
import DriveFileDetail from "./components/listers/DriveFileDetail"

import IndexManager from "./components/listers/IndexCards"
import IndexDetail from "./components/listers/IndexDetail"

import VideoManager from "./components/listers/VideoCards"
import VideoDetail from "./components/listers/VideoDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [

            {
                path: '/fileInfos',
                name: 'FileInfoView',
                component: FileInfoView
            },
            {
                path: '/fileInfos/:id',
                name: 'FileInfoViewDetail',
                component: FileInfoViewDetail
            },
            {
                path: '/driveFiles',
                name: 'DriveFileManager',
                component: DriveFileManager
            },
            {
                path: '/driveFiles/:id',
                name: 'DriveFileDetail',
                component: DriveFileDetail
            },

            {
                path: '/indices',
                name: 'IndexManager',
                component: IndexManager
            },
            {
                path: '/indices/:id',
                name: 'IndexDetail',
                component: IndexDetail
            },

            {
                path: '/videos',
                name: 'VideoManager',
                component: VideoManager
            },
            {
                path: '/videos/:id',
                name: 'VideoDetail',
                component: VideoDetail
            },




    ]
})
