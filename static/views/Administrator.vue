<template>
    <div>
    
    <Logedbar></Logedbar>
    <v-toolbar  dark
    
    dense
    flat>
  

    <v-spacer></v-spacer>

  <v-btn  >
       Kreiraj trenere
    </v-btn>
    <v-btn  >
       Kreiraj menadzera
    </v-btn>
    <v-btn @click="SOMode" >
       Kreiraj sportski objekat
    </v-btn>
    <v-btn  >
       Kupci
    </v-btn>
    <v-btn   >
       Komentari
    </v-btn>
    <v-btn  @click="ProfilMode" >
       Moj profil 
    </v-btn>
    

   
    
  </v-toolbar>



<template v-if="pocetna">
   <Card></Card>
</template>
<template v-if="profil">
   <Profsettings :id=idd ></Profsettings>
</template>

<template v-if="objekat">
   <Addso v-on:close-addso="objekat = false, pocetna = true"></Addso>
</template>

 
    </div>
</template>
undefined
<script>






undefined
undefined
undefined
module.exports={
  
  name:'Administrator',
  data(){
        return{
            idd: this.$route.params.username,
            pocetna:true,
            trener:false,
            menadzer:false,
            objekat:false,
            kupci:false,
            komentari:false,
            profil:false
        }
},
 
  methods:{
      ProfilMode(){
         this.profil=true,

         this.pocetna=false,
         this.trener=false,
         this.menadzer=false,
         this.objekat=false,
         this.kupci=false,
         this.komentari=false
         
      },
      SOMode(){
         console.log("anas")
         this.profil=false,
         this.pocetna=false,
         this.trener=false,
         this.menadzer=false,

         this.objekat=true,
         
         this.kupci=false,
         this.komentari=false
      }
   }
   }



</script>