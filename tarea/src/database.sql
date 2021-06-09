CREATE TABLE "tbContactos" (
  "id" int,
  "nombre" varchar,
  "telefono" varchar,
  "idTipo" int,
  PRIMARY KEY ("id", "idTipo")
);

CREATE TABLE "TiposContacto" (
  "id" int[pk],
  "tipo" varchar
);

ALTER TABLE "telefono" ADD FOREIGN KEY ("idTipo") REFERENCES "TiposContacto" ("id");

