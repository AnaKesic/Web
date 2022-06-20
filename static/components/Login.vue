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
                        <v-form>
                           <v-text-field v-model="username" :rules="rule"
                             
                              name="username"
                              label="Korisnicko ime"
                              type="text"
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
                        <v-btn color="primary"   v-on:click="buttonClickLogin" to="/">Prijavi se</v-btn>
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
    username: '',
    password: '',
    rule: [
  v => !!v || 'Polje je obavezno za popuniti',
 
    ]}
},
methods:{
   buttonClickLogin() {
          var user = {
            korisnickoIme: this.username,
            sifra: this.password,
            
          }
          axios.post("http://localhost:8080/rest/teretana/login", user)
            .then(r => {
              console.log(r.data)
            })
        }
       

}}
</script>