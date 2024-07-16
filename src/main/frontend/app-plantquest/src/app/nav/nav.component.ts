import { Component } from '@angular/core';
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [
    NgOptimizedImage,
  ],
  templateUrl: './nav.component.html',
  styleUrl: '/dist/css/bootstrap.css',
})
export class NavComponent {
    logoPath = '/assets/images/Logo.png';
    searchImage = '/assets/images/search_FILL0_wght400_GRAD0_opsz24.png';
}
