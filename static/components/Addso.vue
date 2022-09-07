<template>
    <div>  <v-card width="60%" height="80%" class="pa-6"  >
                               <v-card-text>
                                  <v-form ref="settingsForm" v-model="valid">
                                    <v-row>
                                        <v-col cols="12">
                                           
                                             <v-text-field  v-model="Objekat.naziv" :rules="[rules.required]" label="Ime objekta" required></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                          <v-combobox
                                              v-model="select"
                                              :items="items"
                                              label="Izaberi tip teretane"
                                              
                                            ></v-combobox>
                                            <v-col cols="12">
                                           
                                           <v-text-field  v-model="Objekat.lokacija" :rules="[rules.required]" label="Lokacija objekta" required></v-text-field>
                                      </v-col>
                                        </v-col>
                                        <div>
                                            <div class="imagePreviewWrapper" :style="{ 'background-image': `url(${previewImage})` }" @click="selectImage"> </div>
                                        
                                            <input ref="fileInput" type="file" @input="pickFile">
                                          </div>
                                        <!-- <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Objekat.lokacija" :rules="[rules.required]" label="Lokacija" maxlength="20" required></v-text-field> 
                                        </v-col> 
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Objekat." :rules="[rules.required]" label="Lokacija" maxlength="20" required></v-text-field> 
                                        </v-col>  -->
                                      </v-row>
                                      </v-form>
                                        </v-card-text>
                                      </v-card>
                                    </div>
                                       
</template>
<script>
module.exports={
  name:'Addso',
  data(){
    return{
      Objekat:{
        "naziv" :"",
        "lokacija":""
      },
         items:[
         "SVI",
          "TERETANA",
           "BAZEN",
            "SPORTSKI_CENTAR",
             "PLESNI_STUDIO"
         ],
         rules: {
                required: value => !!value || "Required.",
                min: v => (v && v.length >= 8) || "Min 8 characters"
            },
            previewImage: null
            
  }
 
},
methods:{
  selectImage () {
          this.$refs.fileInput.click()
      },
      pickFile () {
        let input = this.$refs.fileInput
        let file = input.files
        if (file && file[0]) {
          let reader = new FileReader
          reader.onload = e => {
            this.previewImage = e.target.result
          }
          reader.readAsDataURL(file[0])
          this.$emit('input', file[0])
        }
      }
}
}
</script>
