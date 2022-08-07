<template>

    <v-card outlined>
        <v-card-title>
            FileInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="FileSize" v-model="item.fileSize" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FileName" v-model="item.fileName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Index" v-model="item.index" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="UploadStatus" v-model="item.uploadStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VideoUrl" v-model="item.videoUrl" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'FileInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/fileInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

