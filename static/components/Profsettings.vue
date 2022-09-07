<template>
    <div class="d-flex align-center justify-center">
       
      
        <v-card width="60%" class="pa-6"  >
                               <v-card-text>
                                  <v-form ref="settingsForm" v-model="valid">
                                    <v-row>
                                        <v-col cols="12">
                                           
                                             <v-text-field :disabled="true" v-model="Korisnik.kIme" :rules="[rules.required]" label="Username" required></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Korisnik.ime" :rules="[rules.required]" label="First Name" maxlength="20" required></v-text-field>
                                        </v-col>
                                        <v-col cols="12" sm="6" md="6">
                                            <v-text-field :disabled="sSet" v-model="Korisnik.prezime" :rules="[rules.required]" label="Last Name" maxlength="20" required></v-text-field> 
                                        </v-col> 
                                         <v-col cols="12">
                                            <template>
                                              <div>
                                                
                                                <v-menu
                                                  ref="menu"
                                                  :disabled="sSet"
                                                  :close-on-content-click="false"
                                                  transition="scale-transition"
                                                  offset-y
                                                  min-width="auto"
                                                >
                                                  <template v-slot:activator="{ on, attrs }">
                                                    <v-text-field
                                                    :disabled="sSet"
                                                      v-model="Korisnik.rodjendan"
                                                      label="Birthday date"
                                                      prepend-icon="mdi-calendar"
                                                      readonly
                                                      v-bind="attrs"
                                                      v-on="on"
                                                      :rules="[rules.required]"
                                                    ></v-text-field>
                                                  </template>
                                                  <v-date-picker
                                                    v-model="Korisnik.rodjendan"
                                                    :disabled="sSet"
                                                    :max="(new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10)"
                                                    min="1950-01-01"
                                                    required
                                                  ></v-date-picker>
                                                </v-menu>
                                              </div>
                                            </template>
                                            
                                            
                                        </v-col> 
                                         <v-col cols="12">
                                            <v-radio-group :disabled="sSet" v-model="Korisnik.pol" :rules="[rules.required]" label="Gender" required row>
                                              <v-radio label="Muški"  value="MUSKI"  >    </v-radio>
                                              <v-radio label="Ženski" value="ZENSKI">  </v-radio>
                                            
                                            </v-radio-group>
                                        </v-col> 
                                        <v-col cols="12">
                                            <v-text-field :disabled="sSet" v-model="Korisnik.sifra"  :rules="[rules.required, rules.min]"  label="Password" hint="At least 8 characters" counter ></v-text-field>
                                        </v-col>
                                        <template v-if="!sSet">
                                        <v-col class="d-flex ml-auto" cols="6" sm="3" xsm="12">
                                            <v-btn x-large block :disabled="!valid" color="success" @click="validate">Izmeni</v-btn>
                                        </v-col>
                                        <v-col class="d-flex ml-auto" cols="6" sm="3" xsm="12">
                                            <v-btn x-large block  color="success" @click="cancel">Odustani</v-btn>
                                        </v-col>
                                          </template> 
                                          <template v-if="sSet">
                                                <v-btn @click="StartSettings">Izmeni</v-btn>

                                          </template>
                                        <v-spacer></v-spacer>
                                         
                                    </v-row>
                                </v-form>
                            </v-card-text>
                        </v-card> 
          
    </div>
</template>
<script>
undefined

 module.exports = {
    name: 'Profsettings',
    props:{
        id:String
    },
   mounted() {
        this.defineUser()
        },
    data(){
        return{
            User:{},
             Korisnik : {
             "kIme":'',
             "ime": '',
              "prezime": '',
              "rodjendan":'',
              "pol": '',
              "sifra": ''
            },
        valid: true,
        sett:false,
        sSet:true,
        rules: {
                required: value => !!value || "Required.",
                min: v => (v && v.length >= 8) || "Min 8 characters"
            }

        }

        },
    methods:{
        defineUser(){
            axios.get("http://localhost:8080/rest/korisnk/getById/"+this.id)
            .then(r=>{
                this.User=r.data
                this.Korisnik.ime=this.User.ime
                this.Korisnik.prezime=this.User.prezime
                this.Korisnik.rodjendan=this.User.datumRodjenja
                this.Korisnik.pol=this.User.pol
                this.Korisnik.kIme=this.User.korisnickoIme
                this.Korisnik.sifra=this.User.lozinka
                console.log("ana")
                console.log(this.User)
                console.log(this.Korisnik)
            
            }
            )
        },
        StartSettings(){
            this.sSet=false;
        }
        ,
        validate() {
      
            
          axios.post("http://localhost:8080/rest/korisnik/settings", this.Korisnik)
            .then(r => {
              console.log(r.data)
                this.User=r.data;

                this.Korisnik.ime=this.User.ime;
                this.Korisnik.prezime=this.User.prezime;
                this.Korisnik.rodjendan=this.User.datumRodjenja;
                this.Korisnik.pol=this.User.pol;
                this.Korisnik.kIme=this.User.korisnickoIme;
                this.Korisnik.sifra=this.User.lozinka;
                this.sSet=true;
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
        cancel(){
            this.Korisnik.ime=this.User.ime;
                this.Korisnik.prezime=this.User.prezime;
                this.Korisnik.rodjendan=this.User.datumRodjenja;
                this.Korisnik.pol=this.User.pol;
                this.Korisnik.kIme=this.User.korisnickoIme;
                this.Korisnik.sifra=this.User.lozinka;
                this.sSet=true;
        }
       
 }}
</script>
