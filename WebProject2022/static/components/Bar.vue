<template>
   
      <v-toolbar  dark
      height="50">
        <v-toolbar-title> Ime teretane</v-toolbar-title>

        <v-spacer></v-spacer>

        

       <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
       </v-btn>
        <v-btn  @click="goToHome()">
           Log in
        </v-btn>

         <v-btn >
           Sign in
        </v-btn>
        
      </v-toolbar>
         
    




</template>
<script>


module.exports={
  name:'Bar',
  methods:{
   goToHome(){
   this.$router.push('/login'); 
      }
}}
</script>
<style>
</style>
