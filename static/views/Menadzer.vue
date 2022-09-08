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
    <v-btn color="red"  @click="dodaj">Dodaj trening</v-btn>
    <v-btn color="red"  @click="treneri">Treneri</v-btn>
    <v-btn color="red"  @click="posetioci">Posetioci</v-btn>
    <v-btn color="red"  @click="treninzi">Treninzi</v-btn>
   <v-btn color="red" @click="nazad">Nazad</v-btn>
   </v-row>
   <Jedanobjekat :id=idd></Jedanobjekat>
</template>
<template  v-if="dod">
 <Novitrening></Novitrening>
 <v-row justify="center">
   <v-btn color="red"  @click="nazadd">Nazad</v-btn>
   </v-row>
</template>
<template v-if="tren">
  <v-btn color="red"  @click="nazadd">Nazad</v-btn>
</template>
<template v-if="pos">
  <Posetioci :id=idd></Posetioci>
  <v-btn color="red"  @click="nazadd">Nazad</v-btn>
</template>
<template v-if="tr">
  <v-btn color="red" @click="nazadd">Nazad</v-btn>
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
            profil:false,
            dod:false,
            tren:false,
            pos:false,
            tr:false
            
        }
},
 
  methods:{
      ProfilMode(){
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=true,
        this.dod=false,
        this.tren=false,
        this.pos=false,
        this.tr=false
      },
      kk(){
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=true,
        this.profil=false,
        this.dod=false,
        this.tren=false,
        this.pos=false,
        this.tr=false

      },
      mso(){
        this.pocetna=false,
        this.mojSportskiObjekat=true,
        this.komentari=false,
        this.profil=false,
        this.dod=false,
        this.tren=false,
        this.pos=false,
        this.tr=false

      },
      nazad(){
        this.pocetna=true,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false,
        this.dod=false,
        this.tren=false,
        this.pos=false,
        this.tr=false

      },
      nazadd(){
        this.dod=false,
        this.pocetna=false,
        this.mojSportskiObjekat=true,
        this.komentari=false,
        this.profil=false,
        this.tren=false,
        this.pos=false,
        this.tr=false

      },
      dodaj(){
        this.dod=true,
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false,
        this.tren=false,
        this.pos=false,
        this.tr=false

      },
      treneri(){
        this.dod=false,
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false,
        this.tren=true,
        this.pos=false,
        this.tr=false

      },
      posetioci(){
        this.dod=false,
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false,
        this.tren=false,
        this.pos=true,
        this.tr=false

      },
      treninzi(){
        this.dod=false,
        this.pocetna=false,
        this.mojSportskiObjekat=false,
        this.komentari=false,
        this.profil=false,
        this.tren=false,
        this.pos=false,
        this.tr=true

      }

    
    
      
     
   }
}



</script>