<template>
      <v-toolbar  dark
        color="red"
        dense
        flat>
      <v-toolbar-title> Ana&Tanja GymPass</v-toolbar-title>

        <v-spacer></v-spacer>

      
        <v-btn  @click="kk()" >
           Odjavi se
        </v-btn>

        
      </v-toolbar>
         
   
</template>
<script>


undefined
 module.exports = {
    name: 'Logedbar',
    methods:{
      kk(){
        this.$router.push('/'); 
      }
    }

 }


</script>
