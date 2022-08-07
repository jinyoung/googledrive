<template>

<v-card style="width:300px; margin-left:5%;" outlined>
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>

    <v-img
      style="width:290px; height:150px; border-radius:10px; position:relative; margin-left:5px; top:5px;"
      src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
    ></v-img>

    <v-card-title v-if="value._links">
        File # {{value._links.self.href.split("/")[value._links.self.href.split("/").length - 1]}}
    </v-card-title >
    <v-card-title v-else>
        File
    </v-card-title >

    <v-card-text style = "margin-left:-15px; margin-top:10px;">

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="Filename" v-model="value.filename"/>
          </div>
          <div class="grey--text ml-4" v-else>
            Filename :  {{value.filename }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="UserId" v-model="value.userId"/>
          </div>
          <div class="grey--text ml-4" v-else>
            UserId :  {{value.userId }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="FileUrl" v-model="value.fileUrl"/>
          </div>
          <div class="grey--text ml-4" v-else>
            FileUrl :  {{value.fileUrl }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="FileSize" v-model="value.fileSize"/>
          </div>
          <div class="grey--text ml-4" v-else>
            FileSize :  {{value.fileSize }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="FileType" v-model="value.fileType"/>
          </div>
          <div class="grey--text ml-4" v-else>
            FileType :  {{value.fileType }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-text-field label="UploadStatus" v-model="value.uploadStatus"/>
          </div>
          <div class="grey--text ml-4" v-else>
            UploadStatus :  {{value.uploadStatus }}
          </div>


          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">
            <v-menu
                v-model="menu"
                width="290px"
            >
                <template v-slot:activator="{ on, attrs }">
                <v-text-field
                    v-model="value.regDate"
                    label="RegDate"
                    prepend-icon="mdi-calendar"
                    readonly
                    v-bind="attrs"
                    v-on="on"
                ></v-text-field>
                </template>
                <v-date-picker
                v-model="value.regDate"
                :min="new Date().toISOString().substr(0, 10)"
                @input="menu = false"
                ></v-date-picker>
            </v-menu>
          </div>
          <div class="grey--text ml-4" v-else>
            RegDate :  {{value.regDate }}
          </div>

          <div class="grey--text ml-4" v-if="editMode" style = "margin-top:-20px;">

            <v-radio-group
              v-model="value.starred"
              row
            >
                <template v-slot:label>
                    <div>starred</div>
                </template>
              <v-radio
                label="Y"
                value="true"
              ></v-radio>
              <v-radio
                label="N"
                value="false"
              ></v-radio>
            </v-radio-group>
          </div>
          <div class="grey--text ml-4" v-else>
            Starred :  {{value.starred }}
          </div>



    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions style = "position:absolute; right:0; bottom:0;">
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="edit"
        v-if="!editMode"
      >
        Edit
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="save"
        v-else
      >
        Save
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="remove"
        v-if="!editMode"
      >
        Delete
      </v-btn>
      
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="upload"
        v-if="!editMode"
      >
        Upload
      </v-btn>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="star"
        v-if="!editMode"
      >
        Star
      </v-btn>
    </v-card-actions>
  </v-card>


</template>

<script>
  const axios = require('axios').default;
  
  
  
  
  
  
  
  
  
  
  export default {
    name: 'File',
    components:{
    },
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        date: new Date().toISOString().substr(0, 10),
    }),
    created(){
    },

    methods: {
      edit(){
        this.editMode = true;
      },
      async save(){
        try{
          var temp = null;
          if(this.isNew){
            temp = await axios.post(axios.fixUrl('/files'), this.value)
          }else{
            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
          }

          this.value = temp.data;

          this.editMode = false;
          this.$emit('input', this.value);

          if(this.isNew){
            this.$emit('add', this.value);
          }else{
            this.$emit('edit', this.value);
          }

        }catch(e){
          alert(e.message)
        }
      },
      async remove(){
        try{
          await axios.delete(axios.fixUrl(this.value._links.self.href))
          this.editMode = false;
          this.isDeleted = true;

          this.$emit('input', this.value);
          this.$emit('delete', this.value);

        }catch(e){
          alert(e.message)
        }
      },
      
      async star(){
        try{
          var temp = await axios.put(axios.fixUrl(this.value._links.star.href))
          this.value = temp.data;
          this.editMode = false;
        }catch(e){
          alert(e.message)
        }
      },
      
    },
  }
</script>

