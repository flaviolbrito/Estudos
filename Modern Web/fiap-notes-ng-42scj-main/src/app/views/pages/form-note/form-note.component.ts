import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-note',
  templateUrl: './form-note.component.html',
  styleUrls: ['./form-note.component.css']
})
export class FormNoteComponent implements OnInit {

  title = "FIAP NOTES";

  checkoutForm = FormGroup;
  constructor() {
    private formBuilder: FormBuilder;
   }
2
  ngOnInit(): void {
  }

}
