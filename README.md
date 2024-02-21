 ngOnInit(){
    this.us.loggedInUser().subscribe((u)=>{
      this.user = u
      if(u.profile.profileType == "RISQUE REPORTING"){
        this.unite = "BIAT"
        this.chartService.getCategories(this.unite).subscribe(cat=>{
          this.result = cat.map((element) => element.replace(/"/g, ''))
          this.totalEng(this.unite)
          this.totalEngDec22(this.unite)
          this.totalEngMars23(this.unite)
          this.getTauxDeSaisieDeBilan(this.unite)
          this.getTauxDeRenvPCG(this.unite)
          this.getTauxGenerationCDL(this.unite)
          this.getTauxGenerationCreditParticuliers(this.unite)
          this.getTauxCDL(this.unite)
        })
      }else{
        this.unite = u.libelle
        this.chartService.getCategories(this.unite).subscribe(cat=>{
          this.result = cat.map((element) => element.replace(/"/g, ''))
          this.totalEng(this.unite)
          this.totalEngDec22(this.unite)
          this.totalEngMars23(this.unite)
          this.getTauxDeSaisieDeBilan(this.unite)
          this.getTauxDeRenvPCG(this.unite)
          this.getTauxGenerationCDL(this.unite)
          this.getTauxGenerationCreditParticuliers(this.unite)
          this.getTauxCDL(this.unite)
        })
      }
    })
