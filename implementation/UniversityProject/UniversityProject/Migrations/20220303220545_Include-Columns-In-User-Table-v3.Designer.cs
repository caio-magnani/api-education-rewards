﻿// <auto-generated />
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Storage.ValueConversion;
using UniversityProject.Models;

namespace UniversityProject.Migrations
{
    [DbContext(typeof(DataBase))]
    [Migration("20220303220545_Include-Columns-In-User-Table-v3")]
    partial class IncludeColumnsInUserTablev3
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
#pragma warning disable 612, 618
            modelBuilder
                .HasAnnotation("Relational:MaxIdentifierLength", 128)
                .HasAnnotation("ProductVersion", "5.0.12")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("UniversityProject.Models.User", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd()
                        .HasColumnType("int")
                        .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

                    b.Property<string>("CodigoAcesso")
                        .HasColumnType("varchar(10)");

                    b.Property<string>("Cpf")
                        .IsRequired()
                        .HasColumnType("varchar(50)");

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasColumnType("varchar(100)");

                    b.Property<string>("NivelAcesso")
                        .HasColumnType("varchar(5)");

                    b.Property<string>("Nome")
                        .IsRequired()
                        .HasColumnType("nvarchar(250)");

                    b.Property<string>("Telefone")
                        .IsRequired()
                        .HasColumnType("varchar(50)");

                    b.Property<int>("TipoUsuario")
                        .HasColumnType("int");

                    b.HasKey("Id");

                    b.ToTable("Users");
                });
#pragma warning restore 612, 618
        }
    }
}
