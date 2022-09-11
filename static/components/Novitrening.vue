<template>

<v-card class="px-4">
                            <v-card-text>
                              <template v-if="une" >
                                <div class="red--text"> Promenite korisnicko ime, posto ovo vec postoji!</div>
                              </template>
                                <v-form ref="registerForm" v-model="valid">
                                    <v-row>
                                        <v-col cols="8">
                                            <v-select
                                              :rules="[rules.required]"
                                              v-model="Trening.tipTreninga"
                                              :items="sadrzaj"
                                              label="Izaberi tip treninga*:"
                                              
                                              required
                                                >
                                            </v-select>
                                            </v-col>
                                        <v-col cols="12">
                                            <v-text-field v-model="Trening.naziv" :rules="[rules.required]" label="Ime treninga*" required></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field v-model="Trening.opis"  label="Opis treninga" maxlength="20" ></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field v-model="Trening.trajanje"  label="Trajanje" maxlength="20" ></v-text-field>
                                        </v-col>
                                        <v-col cols="12">
                                            <v-select
                                             
                                              v-model="Trening.nazivTrenera"
                                              :items="treneri"
                                              label="Izaberi tip treninga*:"
                                              
                                              required
                                                >
                                            </v-select>
                                            </v-col>
                                            <v-col cols="12">
                                              <v-file-input
                                                      v-model="image"
                                                      accept="image/*"
                                                      label="Select logo"
                                                      chips
                                                      prepend-icon="mdi-camera"
                                                      style="margin-left:10px;margin-right:10px;"
                                                  ></v-file-input>
                                           </v-col>
                                       
                                       
                                        <v-spacer></v-spacer>
                                        <v-col class="d-flex ml-auto" cols="12" sm="3" xsm="12">
                                            <v-btn  :disabled="uslov" color="success" @click="sendForm">Napravi</v-btn>
                                        </v-col>
                                    </v-row>
                                </v-form>
                            </v-card-text>
                        </v-card>
                  
           


      
     
    
  	
</template>
<script>
    undefined
    module.exports = {
      name: 'Novitrening',
      computed:{
      uslov(){
        console.log(anaa)
        if(this.image!==null && this.Trening.naziv!=="" && this.Trening.tipTreninga!==""){
          this.uslov= true
        }
        else{
          this.uslov= false
        }
        console.log(validate)
      }
  },
  watch:{
    'Teretana.naziv':function(value){
           
        if(this.image!==null && this.Trening.naziv!=="" && this.Trening.tipTreninga!==""){
          this.uslov= false
        }
        else{
          this.uslov= true
        }
     },
     'Teretana.tipTreninga':function(value){
          
        if(this.image!==null && this.Trening.naziv!=="" && this.Trening.tipTreninga!==""){
          this.uslov= false
        }
        else{
          this.uslov=true
        }
     },
     

     image:function(value){
      
        if(this.image!==null && this.Trening.naziv!=="" && this.Trening.tipTreninga!==""){
          this.uslov= false
        }
        else{
          this.uslov= true
        }
     }}
      ,
    
      
     mounted() {
          this.ucitajTrenere(),
          this. defineUser()
          },
      data(){
          return{
              sadrzaj:[],
              treneri:[],
              Trening:{
                "naziv":"",
                "tipTreninga":"",
                "objekatGdePripada":"",
                "trajanje":"",
                "nazivTrenera":"",
                "opis":"",
                "slika":""},
                rules: {
                required: value => !!value || "Required.",
                min: v => (v && v.length >= 8) || "Min 8 characters"
                },
                image: null,
                une: false,
                uslov:true,
                User:{},
                objekat:{},
                nazivSpObj:''
                }

              
           
          
    
          },
      methods:{

        reset() {
        this.$refs.registerForm.reset();
        },
        resetValidation() {
        this.$refs.registerForm.resetValidation()
        },
          
        ucitajTrenere(){
            axios.get('rest/korisnik/getTreneri')
              .then(r =>
                  {
                          
                          console.log(r.data)
                          this.treneri = r.data                          
                          
                          
                      
                  }
    
              )	
          },
          async sendForm(){
            // var logo2 = this.image.replace(/^.*\\/, "");
                this.Trening.slika=await this.upload()
             
               if(this.Trening.trajanje===""){
                this.Trening.trajanje=0
               }
               this.objekatGdePripada=this.nazivSpObj

                axios.post('http://localhost:8080/rest/trening/addTrening',this.Trening)
                    .then(r=>{
                    console.log(r.data)
                    console.log("anaa")
                    this.$emit('close-addso', false);  
                    })
                    .catch(err => { 
                if (err.response) { 
                  // client received an error response (5xx, 4xx)
                      
                      this.resetValidation();
                      this.une=true;
                      

                }
                else{
                  console.log("usao");
                  
                }
                

                })
            
            

            
      },

      async upload() {
            console.log("anna")
            const fileToUpload = new FormData();
            fileToUpload.append('file', this.image);
            var image = await axios.post("http://localhost:8080/rest/file/upload", fileToUpload)
                .then(r => {
                    return r.data;
                })
            return image;
        },
        ucitajObjekatSadrzaj(){
                
                 var men=this.$route.params.username;
                
                 axios.get("http://localhost:8080/rest/menadzer/getSadrzaj",men )
                    .then(r=>{
                    console.log(r.data)
                    this.Sadrzaj=r.data
                })


        },
        defineUser(){
            var men=this.$route.params.username;
                

             axios.get("http://localhost:8080/rest/korisnk/getById/"+men)
             .then(r=>{
                 console.log(r.data)
                 this.User=r.data
                 this.nazivSpObj=this.User.sportskiObjekat
                 this.ucitaj()
             
             }
             )
         },
         ucitaj(){
             axios
             .get('rest/ucitajobjmen/'+this.nazivSpObj)
             .then(response =>
                 {
                         
                         console.log(response.data)
                         this.objekat = response.data
                         this.sadrzaj=this.objekat.sadrzaj
                         
                         
                     
                 }
 
             )	
         }
      }
    }

    </script>