<template>
   
      <v-toolbar  dark
        color="red"
        dense
        flat>
      <v-toolbar-title> Ana&Tanja GymPass</v-toolbar-title>

        <v-spacer></v-spacer>

      
        <v-btn  @click="kk()" >
           Prijavi se
        </v-btn>

         <v-btn @click="goToHome()">
           Napravi nalog
        </v-btn>
        
      </v-toolbar>
         
    




</template>
<script>


module.exports={
  name:'Bar',
 
  methods:{
   goToHome(){
    this.$router.push('/signup'); 
      },
   kk(){
    this.$router.push('/login');

   }
   }
}
</script>
<style>
</style>
