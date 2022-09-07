<template>
    <div>
    
    <Logedbar></Logedbar>
    <v-toolbar  dark
    
    dense
    flat>
  

    <v-spacer></v-spacer>

  <v-btn  @click="mso" >
    Moj sportski objekat
    </v-btn>
    <v-btn  @click="kk">
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
   <v-row justify="center">
   <v-btn color="red"  @click="nazad">Nazad</v-btn>
   </v-row>
</template>
<template v-if="komentari">
    <p>Komentari se nalze ispod!</p>
    <v-row justify="center">
   <v-btn color="red"  @click="nazad">Nazad</v-btn>
   </v-row>
</template>
<template v-if="mojSportskiObjekat">
    <v-row justify="center">
   <v-btn color="red"  @click="nazad">Nazad</v-btn>
   </v-row>
</template>






 
    </div>
</template>
undefined
<script>






undefined
undefined
undefined
module.exports={
  
  name:'Menadzer',
  data(){
        return{
            idd: this.$route.params.username,
            pocetna:true,
            mojSportskiObjekat:false,
            komentari:false,
            profil:false
        }
},
 
  methods:{
      ProfilMode(){
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=true
      },
      kk(){
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=true,
        this.profil=false

      },
      mso(){
        this.pocetna=false,
        this.mojSportskiObjekat=true,
        this.komentari=false,
        this.profil=false

      },
      nazad(){
        this.pocetna=true,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false

      }
    
    
      
     
   }
}



</script>