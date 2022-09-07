<template>
   

<div id="app">
    <v-app>
        <v-dialog v-model="dialog" persistent max-width="600px" min-width="360px">
            <div>
                
                        <v-card class="px-4">
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
                                            <v-btn x-large block :disabled="!valid" color="success" @click="validate">Register</v-btn>
                                        </v-col>
                                    </v-row>
                                </v-form>
                            </v-card-text>
                        </v-card>
                  
            </div>
        </v-dialog>
    </v-app>
</div>
</template>
<script>
module.exports={
name:"signup",
 
 
methods: {

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
              "sifra": this.password
            };
          axios.post("http://localhost:8080/rest/korisnik/signup", Korisnik)
            .then(r => {
              console.log(r.data)
              this.$router.push({name:'kupac', params: {username:this.username}})
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
      
    
   
    }
  ,
data() {
   return {
    dialog: true,
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
  }}
}
</script>