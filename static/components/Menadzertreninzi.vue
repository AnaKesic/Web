<template>

   
       
    
    <v-data-table :headers="headers" :items="treninzi" hide-default-footer sortBy="Naziv">
        
        <template v-slot:top>
      <v-toolbar
        flat
      ><v-dialog
          v-model="dialog"
          max-width="500px"
        >
        <v-card>
            <v-card-title>
              <span class="text-h5">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.naziv"
                      label="Naziv"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.tipTreninga"
                      label="Tip Treninga"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.trajanje"
                      label="Trajanje"
                    ></v-text-field>
                  </v-col>
                  <v-col
                    cols="12"
                    sm="6"
                    md="4"
                  >
                    <v-text-field
                      v-model="editedItem.opis"
                      label="Opis"
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                color="blue darken-1"
                text
                @click="close"
              >
                Cancel
              </v-btn>
              <v-btn
                color="blue darken-1"
                text
                @click="save"
              >
                Save
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
        </v-toolbar>
        </template>
        <template v-slot:item.action="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="editItem(item)"
      >
        mdi-pencil
      </v-icon>
      </template>
      </v-data-table>
      </template>

       
        

<script>
undefined
module.exports = {
  name: 'Menadzertreninzi',
  props:{
      id:String
  },
 mounted() {
      this.defineUser()
     
      },
  data(){
      return{
        
        dialog: false,
        editedIndex: -1,
      editedItem: {
        naziv: '',
        tipTreninga:'',
        trajanje:'',
        opis:''},
        defaultItem: {
            naziv: '',
            tipTreninga:'',
            trajanje:'',
        opis:''},
          User:{},
          nazivSpObj:'',
          treninzi:[],
          headers: [
      { text: 'Naziv',value:'naziv'},
      { text: 'Tip',value:'tipTreninga' },
      { text: 'Trajanje',value:'trajanje'},
      { text: 'Opis',value:'opis'},
      { text: 'Trener',value:'nazivTrenera'},
      { text: "", value: "action" }
      
      
    ]
           
      }
      },
      computed: {
      formTitle () {
        return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
      },
    },
    watch: {
      dialog (val) {
        val || this.close()
      },
      dialogDelete (val) {
        val || this.closeDelete()
      },
    },
  methods:{
      defineUser(){
          axios.get("http://localhost:8080/rest/korisnk/getById/"+this.id)
          .then(r=>{
              
              console.log("tanja")
              this.User=r.data
              this.nazivSpObj=this.User.nazivSpObj
              this.ucitajTrenere()
          
          }
          )
      },
      ucitajTrenere(){
          axios.get('rest/trening/getTreninzi/'+this.nazivSpObj)
          .then(r =>
              {
                      
                      console.log(r.data)
                      this.treninzi = r.data;
                      
                      
                      
                  
              }
          )	
      },
      editItem(item){
        this.editedIndex = this.treninzi.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },
      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },
      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.treninzi[this.editedIndex], this.editedItem)
        } else {
          this.treninzi.push(this.editedItem)
        }
        this.close()
      },
    },
  }
      
 
</script>