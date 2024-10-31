import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoProdutoComponent } from './info-produto.component';

describe('InfoProdutoComponent', () => {
  let component: InfoProdutoComponent;
  let fixture: ComponentFixture<InfoProdutoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InfoProdutoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InfoProdutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
