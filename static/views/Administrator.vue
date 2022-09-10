<template>
    <div>
    
    <Logedbar></Logedbar>
    <v-toolbar  dark
    
    dense
    flat>
  

    <v-spacer></v-spacer>
    <v-btn @click="Pocetnastr">
      Početna
    </v-btn>

  <v-btn @click="Ktrener" >
       Kreiraj trenere
    </v-btn>
    <v-btn @click="menadzerr" >
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
<template v-if="trener">
   <Addtr v-on:close-addtr="trener = false, kupac = true"></Addtr>
</template>
<template v-if="menadzer">
   <Addmen v-on:close-addmen="menadzer = false, kupac = true"></Addmen>
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
      },
      Pocetnastr(){
         this.profil=false,
         this.pocetna=true,
         this.trener=false,
         this.menadzer=false,

         this.objekat=false,
         
         this.kupci=false,
         this.komentari=false

      },
      Ktrener(){
         this.profil=false,
         this.pocetna=false,
         this.trener=true,
         this.menadzer=false,

         this.objekat=false,
         
         this.kupci=false,
         this.komentari=false

      },
      menadzerr(){
         this.profil=false,
         this.pocetna=false,
         this.trener=false,
         this.menadzer=true,

         this.objekat=false,
         
         this.kupci=false,
         this.komentari=false

      }
      
   }
   }



</script>