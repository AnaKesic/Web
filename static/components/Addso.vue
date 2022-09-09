<template>
    <div class="d-flex align-center justify-center"> 
       <v-card width="60%" height="80%" class="pa-6"  >
      <v-card-title>Novi objekat</v-card-title>
                               <v-card-text>
                                  <v-form ref="settingsForm" v-model="valid">
                                    <v-row>
                                        <v-col cols="12">
                                           
                                             <v-text-field  v-model="Objekat.naziv" :rules="[rules.required]" label="Ime objekta*" required></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                          <v-select
                                              v-model="Objekat.tip"
                                              :items="items"
                                              label="Izaberi tip teretane*"
                                              
                                            ></v-select>
                                          </v-col>
                                            <v-col cols="12">
                                            
                                           <v-text-field  v-model="Objekat.lokacija" :rules="[rules.required]" label="Lokacija objekta*" required></v-text-field>
                                      </v-col>
                                           <v-col cols="8">
                                            <v-select
                                              :rules="[rules.required]"
                                              v-model="menadzer"
                                              :items="freeMenagers"
                                              label="Izaberi menadzera"
                                              
                                              required
                                                >
                                            </v-select>
                                            </v-col>
                                            <v-col cols="2" class="d-flex align-center justify-center">
                                              <template>
                                                    <v-row justify="center">
                                                      <v-dialog v-model="dialog" persistent>
                                                        <template v-slot:activator="{ on, attrs }">
                                                          
                                                          <v-btn
                                                           :disabled="noviMedza"
                                                            color="primary"
                                                            dark
                                                            v-bind="attrs"
                                                            v-on="on"
                                                            
                                                          >
                                                            Dodaj
                                                          </v-btn>
                                                        </template>
                                                        <v-card class="px-4">
                                                          <v-card-title> Napravi novog menadzera</v-card-title>
                                                      <v-card-text>
                                                        <template v-if="une" >
                                                          <div class="red--text"> Promenite korisnicko ime, posto ovo vec postoji!</div>
                                                        </template>
                                                          <v-form ref="registerForm" v-model="valid">
                                                              <v-row>
                                                                  <v-col cols="12">
                                                                      <v-text-field v-model="username" :rules="[rules.required]" label="Username" required></v-text-field>
                                                                  </v-col>
                                                                  <v-col cols="12" sm="6" md="6">
                                                                      <v-text-field v-model="firstName" :rules="[rules.required]" label="First Name" maxlength="20" required></v-text-field>
                                                                  </v-col>
                                                                  <v-col cols="12" sm="6" md="6">
                                                                      <v-text-field v-model="lastName" :rules="[rules.required]" label="Last Name" maxlength="20" required></v-text-field>
                                                                  </v-col>
                                                                  <v-col cols="12">
                                                                      <template>
                                                                        <div>
                                                                          
                                                                          <v-menu
                                                                            ref="menu"
                                                                            
                                                                            :close-on-content-click="false"
                                                                            transition="scale-transition"
                                                                            offset-y
                                                                            min-width="auto"
                                                                          >
                                                                            <template v-slot:activator="{ on, attrs }">
                                                                              <v-text-field
                                                                                v-model="date"
                                                                                label="Birthday date"
                                                                                prepend-icon="mdi-calendar"
                                                                                readonly
                                                                                v-bind="attrs"
                                                                                v-on="on"
                                                                                :rules="[rules.required]"
                                                                              ></v-text-field>
                                                                            </template>
                                                                            <v-date-picker
                                                                              v-model="date"
                                                                              
                                                                              :max="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
                                                                              min="1950-01-01"
                                                                              required
                                                                            ></v-date-picker>
                                                                          </v-menu>
                                                                        </div>
                                                                      </template>
                                                                      
                                                                      
                                                                  </v-col> 
                                                                  <v-col cols="12">
                                                                      <v-radio-group v-model="gender" :rules="[rules.required]" label="Gender" required row>
                                                                        <v-radio label="Muški"  value="Muški"  >    </v-radio>
                                                                        <v-radio label="Ženski" value="Ženski">  </v-radio>
                                                                      
                                                                      </v-radio-group>
                                                                  </v-col> 
                                                                  <v-col cols="12">
                                                                      <v-text-field v-model="password" :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'" :rules="[rules.required, rules.min]" :type="show1 ? 'text' : 'password'" name="input-10-1" label="Password" hint="At least 8 characters" counter @click:append="show1 = !show1"></v-text-field>
                                                                  </v-col>
                                                                
                                                                  <v-spacer></v-spacer>
                                                                  <v-col class="d-flex ml-auto" cols="12" sm="3" xsm="12">
                                                                      <v-btn x-large block :disabled="!valid" color="success" @click="validate">Dodaj</v-btn>
                                                                      <v-btn @click="dialog=false"> Odustani </v-btn>
                                                                  </v-col>
                                                              </v-row>
                                                          </v-form>
                                                      </v-card-text>
                                                  </v-card>
                                            </v-dialog>
                                          </v-row>
                                        </template>

                                  <!-- KRAJ DIJALOGA -->
                                </v-col>
                                                                  
                                        <v-col cols="12" >
                                        <v-select
                                            :rules="[rules.required]"
                                            v-model="Objekat.sadrzaj"
                                            :items="activ"
                                            label="Izaberi sadrzaj"
                                            multiple
                                            required
                                            ></v-select>
                                           
                                            </v-col>
                                        <!-- <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Objekat.lokacija" :rules="[rules.required]" label="Lokacija" maxlength="20" required></v-text-field> 
                                        </v-col> 
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Objekat." :rules="[rules.required]" label="Lokacija" maxlength="20" required></v-text-field> 
                                        </v-col>  -->
                                        <v-col
                                              cols="12"
                                             
                                            >
                                              <v-menu
                                                ref="menu2"
                                                v-model="menu2"
                                                :close-on-content-click="false"
                                                :nudge-right="40"
                                                :return-value.sync="Objekat.pocetnoVreme"
                                                transition="scale-transition"
                                                offset-y
                                                max-width="290px"
                                                min-width="290px"
                                              >
                                                <template v-slot:activator="{ on, attrs }">
                                                  <v-text-field
                                                    v-model="Objekat.pocetnoVreme"
                                                    label="Pocetak radnog vremena"
                                                    prepend-icon="mdi-clock-time-four-outline"
                                                    readonly
                                                    v-bind="attrs"
                                                    v-on="on"
                                                  ></v-text-field>
                                                </template>
                                                <v-time-picker
                                                   format="24hr"
                                                  v-model="Objekat.pocetnoVreme"
                                                  full-width
                                                  @click:minute="$refs.menu2.save(Objekat.pocetnoVreme)"
                                                ></v-time-picker>
                                              </v-menu>
                                            </v-col>
                                           
                                            <v-col
                                              cols="12"
                                             
                                            >
                                              <v-menu
                                                ref="menu3"
                                                v-model="menu3"
                                                :close-on-content-click="false"
                                                :nudge-right="40"
                                                :return-value.sync="Objekat.krajnjeVreme"
                                                transition="scale-transition"
                                                offset-y
                                                max-width="290px"
                                                min-width="290px"
                                              >
                                                <template v-slot:activator="{ on, attrs }">
                                                  <v-text-field
                                                    v-model="Objekat.krajnjeVreme"
                                                    label="Kraj radnog vremena"
                                                    prepend-icon="mdi-clock-time-four-outline"
                                                    readonly
                                                    v-bind="attrs"
                                                    v-on="on"
                                                  ></v-text-field>
                                                </template>
                                                <v-time-picker
                                                   format="24hr"
                                                 
                                                  v-model="Objekat.krajnjeVreme"
                                                  full-width
                                                  @click:minute="$refs.menu3.save(Objekat.krajnjeVreme)"
                                                ></v-time-picker>
                                              </v-menu>
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
                                             <v-btn  :disabled="uslov" @click="sendForm"> Posalji zahtev</v-btn> 
                                           
                                      </v-row>


                                      </v-form>
                                        </v-card-text>
                                     
                                      </v-card>
                                    </div>
                                       
</template>
<script>


module.exports={
  name:'Addso',
  computed:{
      uslov(){
        console.log(anaa)
        if(this.image!==null && this.Objekat.naziv!=="" && this.Objekat.lokacija!=="" && this.Objekat.tip!==""){
          this.uslov= true
        }
        else{
          this.uslov= false
        }
        console.log(validate)
      }
  },
  data(){
    return{
      Objekat : {
        "naziv" :'',
        "lokacija":'',
        "tip":'',
        "sadrzaj":[],
        "pocetnoVreme": null,
        "krajnjeVreme": null,
        "logo":''
       
        
       
      },
         items:[
         "SVI",
          "TERETANA",
           "BAZEN",
            "SPORTSKI_CENTAR",
             "PLESNI_STUDIO"
         ],
         activ:[
           "Grupni trening",
           "Personalni trening",
           "Sauna"

         ],
         freeMenagers:[],

         rules: {
                required: value => !!value || "Required.",
                min: v => (v && v.length >= 8) || "Min 8 characters"
            },
        image: null,
        menu2: false,
       
        menu3: false,
       
        uslov:true,
        noviMedza:true,
        showD:false,
        dialog:false,
        menadzer:'',
       
      



        //za dialog podacci
        tab: 0,
    tabs: [
        {name:"Login", icon:"mdi-account"},
        {name:"Register", icon:"mdi-account-outline"}
    ],
    valid: true,
    gender:"",
    date:"",
    username:"",
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    verify: "",
    loginPassword: "",
    loginEmail: "",
    une: false,
    loginEmailRules: [
      v => !!v || "Required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ],
    emailRules: [
      v => !!v || "Required",
      v => /.+@.+\..+/.test(v) || "E-mail must be valid"
    ],

    show1: false,
    rules: {
      required: value => !!value || "Required.",
      min: v => (v && v.length >= 8) || "Min 8 characters"
  }
  }

            
  

  },
watch:{
    'Objekat.naziv':function(value){
           
      if(this.image!==null && this.Objekat.naziv!="" && this.Objekat.lokacija!="" && this.Objekat.tip!="" && this.menadzer!=""){
          this.uslov= false;
        }
        else{
          this.uslov= true;
        }
     },
     'Objekat.lokacija':function(value){
          
      if(this.image!==null && this.Objekat.naziv!="" && this.Objekat.lokacija!="" && this.Objekat.tip!=""  && this.menadzer!=""){
          this.uslov= false;
        }
        else{
          this.uslov= true;
        }
     },
     'Objekat.tip':function(value){
           
           
      if(this.image!==null && this.Objekat.naziv!="" && this.Objekat.lokacija!="" && this.Objekat.tip!=""  && this.menadzer!=""){
          this.uslov= false;
        }
        else{
          this.uslov= true;
        }
     },
     'Objekat.menadzer':function(value){
           
           
           if(this.image!==null && this.Objekat.naziv!="" && this.Objekat.lokacija!="" && this.Objekat.tip!=""  && this.menadzer!=""){
               this.uslov= false;
             }
             else{
               this.uslov= true;
             }
          },

     image:function(value){
      
      if(this.image!=null && this.Objekat.naziv!=="" && this.Objekat.lokacija!=="" && this.Objekat.tip!==""  && this.menadzer!=""){
          this.uslov= false;
        }
        else{
          this.uslov= true;
        }
     }
 
},
mounted() {
  this.getMenagers()
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
        console.log(this.previewImage)
      },
      
      getMenagers(){
        axios.get("http://localhost:8080/rest/menager/getForObject")
            .then(r=>{
                     this.freeMenagers=r.data
                     console.log(this.freeMenagers)
                     this.noviMedza=false

      })
      },
      async sendForm(){
       // var logo2 = this.image.replace(/^.*\\/, "");
        this.Objekat.logo=await this.upload()
        console.log(this.Objekat.logo)
        axios.post("http://localhost:8080/rest/sportski-objekat/add-sportski-objekat",this.Objekat)
            .then(r=>{
              console.log(r.data)
              console.log("anaa")
              this.$emit('close-addso', false);  
            })
            .catch(e => {
              this.$emit('close-addso', false);  
            })

            
      },
      showDialog(){
          this.showD=true

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
      



      //za dialog metodee
      reset() {
      this.$refs.registerForm.reset();
    },
    resetValidation() {
      this.$refs.registerForm.resetValidation()
    },

    validate() {
      var Korisnik = {
             "kIme": this.username,
             "ime": this.firstName,
              "prezime": this.lastName,
              "rodjendan": this.date,
              "pol": this.gender,
              "sifra": this.password,
              "uloga":"MENADZER",
              "sportskiObjekat":this.Objekat.naziv
            };
          axios.post("http://localhost:8080/rest/korisnik/signup", Korisnik)
            .then(r => {
              console.log(r.data)
              console.log(this.username)
              this.freeMenagers=this.username
              this.dialog=false
              this.noviMedza=true
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
        }
      
    
   


}}
</script>
