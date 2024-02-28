<div style=" padding: 10px; background-color: white; overflow-x: scroll; align-items: center;">
      <div class="row" style="margin-bottom: 10px;">
        <div class="col-sm-12 col-md-6">
          <c-input-group class="input-group"><span cinputgrouptext="" id="search-addon"
              style="background-color: rgb(240, 240, 240);" class="border-0 px-1 input-group-text"><svg cIcon=""
                name="cilSearch" size="lg" class="my-1 mx-2 text-disabled icon icon-lg" viewBox="0 0 512 512"
                xmlns="http://www.w3.org/2000/svg" pointer-events="none" role="img">
              </svg></span><input #ser (change)="getSearch(ser.value)" cformcontrol="" type="text"
              placeholder="Rechercher..." aria-label="Search" aria-describedby="search-addon"
              style="background-color: rgb(240, 240, 240); color: rgb(0, 0, 0);" class="border-0 form-control">
          </c-input-group>
        </div>
        <div class="col-sm-12 col-md-6">
          <div class="dataTables_length" id="DataTables_Table_0_length"><label>Afficher <select
                name="DataTables_Table_0_length" aria-controls="DataTables_Table_0"
                class="custom-select custom-select-sm form-control form-control-sm">
                <option value="10">10</option>
                <option value="25">25</option>
                <option value="50">50</option>
                <option value="100">100</option>
              </select> éléments</label></div>
        </div>
      </div>
      <table style="background-color: rgb(250, 250, 250); width: 100%;" _ngcontent-mrh-c220="" ctable=""
        class="table table-bordered">
        <ng-container *ngFor="let res of stringed; let i = index">
          <thead _ngcontent-mrh-c220="" class="fw-semibold text-disabled" *ngIf="i == 0">
            <tr _ngcontent-mrh-c220="">
              <th _ngcontent-mrh-c220="" scope="col" class="text-center">#</th>
              <th _ngcontent-mrh-c220="" scope="col" *ngFor="let r of res.slice(0, -1)">{{r}}</th>
              <th _ngcontent-mrh-c220="" scope="col">
                {{ res[res.length - 1] }}
              </th>
            </tr>
          </thead>
          <tbody _ngcontent-mrh-c220="" *ngIf="i>0">
            <tr _ngcontent-mrh-c220="">
              <td _ngcontent-mrh-c220="" style="font-weight: 400; color: rgb(160, 160, 160)">{{i}}</td>
              <td _ngcontent-mrh-c220="" *ngFor="let t of res.slice(0, -1)">{{t}}</td>
              <td _ngcontent-mrh-c220="">
                <a routerLink="./../classificationdetails/{{res[0]}}" [cTooltip]="
                res[res.length - 1] === 'E' ? 'Cette classification est en attente de la validation finale du responsable' :
                res[res.length - 1] === 'C' ? 'Ce client est Classé' :
                res[res.length - 1] === 'D' ? 'Cette classification est Déposée' :
                res[res.length - 1] === 'PV' ? 'Cette classification est Pré-valider' :
                res[res.length - 1] === 'R' ? 'Cette classification est Refusée' :
                res[res.length - 1] === 'PD' ? 'Cette classification manque d\'informations pour être déposée' : 
                'Ce client n\'a pas de réclamation de classification déposée' " cTooltipPlacement="left">
                  <svg _ngcontent-pkm-c171="" cIcon="" style="size: 20px;" [name]=" 
                  res[res.length - 1] === 'E' ? 'cilAvTimer' : 
                  res[res.length - 1] === 'C' ? 'cilCheckCircle': 
                  res[res.length - 1] === 'PV' ? 'cilCircle':
                  res[res.length - 1] === 'D' ? 'cilCircle' :
                  res[res.length - 1] === 'PD' ? 'cilBan' :
                  res[res.length - 1] === 'R' ? 'cilXCircle' :
                  'cilPlus'" [style.color]="
                  res[res.length - 1] === 'E' ? '#f9b115' : 
                  res[res.length - 1] === 'R' ? '#e55353' :
                  res[res.length - 1] === 'D' ? '#39f' :
                  res[res.length - 1] === 'PD' ? '#000015' :
                  res[res.length - 1] === 'C' ? '#2eb85c' :
                  res[res.length - 1] === 'PV' ? '#39f' :
                  '#4f5d73'"></svg>
                </a>
              </td>
            </tr>
          </tbody>
        </ng-container>
      </table>
      <div class="row">
        <div class="col-sm-12 col-md-6" style="color: rgb(160, 160, 160);">
          Affichage des éléments 1 à {{nombreElements}} sur {{nombreElementsTotal}} éléments
        </div>
        <div class="col-sm-12 col-md-6">
          <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-end">
              <li class="page-item">
                <a class="page-link" href="#" tabindex="-1" style="color: rgb(160, 160, 160);"
                  (click)="toPrevious()">Précédent</a>
              </li>
              <li class="page-item"><a class="page-link" href="#"
                  style="color: white; background-color: rgb(160, 160, 160);" (click)="First20()">1</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: rgb(160, 160, 160);"
                  (click)="second20()">2</a></li>
              <li class="page-item"><a class="page-link" href="#" style="color: rgb(160, 160, 160);"
                  (click)="third20()">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#" style="color: rgb(160, 160, 160);" (click)="toNext()">Suivant</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
