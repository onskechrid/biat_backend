    this.qq = this.filtredQuery.replace("select rcp.cpte","select * from (select rownum r,rcp.cpte")+") where r > "+ this.nombreElements +" and r < "+ this.nbr.nativeElement.value
