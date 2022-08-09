<template>

    <v-data-table
        :headers="headers"
        :items="fileInfo"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FileInfoView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "fileSize", value: "fileSize" },
                { text: "fileName", value: "fileName" },
                { text: "index", value: "index" },
                { text: "uploadStatus", value: "uploadStatus" },
                { text: "videoUrl", value: "videoUrl" },
            ],
            fileInfo : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/fileInfos'))

            temp.data._embedded.fileInfos.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.fileInfo = temp.data._embedded.fileInfos;
        },
        methods: {
        }
    }
</script>

