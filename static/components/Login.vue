<template>
   <v-app id="inspire">
      <v-content>
         <v-container fluid fill-height>
            <v-layout align-center justify-center>
               <v-flex xs12 sm8 md4>
                  <v-card class="elevation-12">
                     <v-toolbar dark color="primary">
                        <v-toolbar-title>Prijavi se!</v-toolbar-title>
                     </v-toolbar>
                     <v-card-text>
                        <template v-if="une" >
                                <div class="red--text"> Podaci nisu dobro uneti</div>
                        </template>
                        <v-form ref="loginForm" v-model="valid">
                           <v-text-field v-model="username" 
                              :rules="rule"
                              name="username"
                              label="Korisnicko ime"
                              type="text"
                              required
                           ></v-text-field>
                           <v-text-field v-model="password" :rules="rule"
                              id="password"
                              
                              name="password"
                              label="Sifra"
                              type="password"
                           ></v-text-field>
                        </v-form>
                     </v-card-text>
                     <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="primary"   :disabled="!valid"  @click="validate" >Prijavi se</v-btn>
                     </v-card-actions>
                  </v-card>
               </v-flex>
            </v-layout>
         </v-container>
      </v-content>
   </v-app>
</template>
<script>
module.exports={
name:"login",
data(){
   return{
    Korisnik:[],
    Korisnik2:"",
    valid:true,
    username: '',
    password: '',
    une:false,
    rule: [
  v => !!v || 'Polje je obavezno za popuniti',
 
    ]
    
}},
methods:{
   validate() {
          var user = {
              "kIme": this.username,
              "sifra": this.password,
              "ime": "",
              "prezime": "",
              "rodjendan": "",
              "pol": "",
          };
          axios.put("http://localhost:8080/rest/teretana/login",user)
            .then(r => {
              
              this.Korisnik=r.data
             
              console.log(r.data)
              if(this.Korisnik.uloga=="TRENER"){
                this.$router.push({name:'trener', params: {korisnik:this.Korisnik.uloga,username:this.username}});
              }
              else if(this.Korisnik.uloga=="KUPAC"){
                this.$router.push({name:'kupac', params: {korisnik:this.Korisnik.uloga,username:this.username}});
              }
              else if(this.Korisnik.uloga=="ADMINISTRATOR"){
                this.$router.push({name:'administrator', params: {username:this.username}});
              }
              else if(this.Korisnik.uloga=="MENADZER"){
                this.$router.push({name:'menadzer', params: {korisnik:this.Korisnik.uloga,username:this.username}});
              }
              else{
                 this.$router.push('/')
              }
            })
            .catch(err => { 
                if (err.response) { 
                  // client received an error response (5xx, 4xx)
                      
                      this.$refs.loginForm.resetValidation();
                      this.une=true;
                      

                }
                else{
                  console.log("usao");
                  
                }
                

                })
        }
       

}}
</script>