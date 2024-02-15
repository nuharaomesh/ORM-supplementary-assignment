@Entity ,

By annotating a class with @Entity, specifying that instances of this class should be mapped to a table in the database. The name of the table is typically derived from the name of the entity class unless explicitly specified.

@Id ,

Define the Primary key of a table when it create database using entity

@OneToMany (mapped by=?) ,

Define the Relationship between the tables and tell how to map it in the database

@JoinColumn ,

When you have a bidirectional association between two entities, one entity will own the relationship (the owning side) and the other entity will be the inverse side. The owning side typically has the @JoinColumn annotation to define the foreign key column.

@GeneratedValue ,

This used to generate primary key values for the entity.
