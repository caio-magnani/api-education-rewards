using Microsoft.EntityFrameworkCore.Migrations;

namespace UniversityProject.Migrations
{
    public partial class IncludeColumnsInUserTablev4 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<string>(
                name: "Senha",
                table: "Users",
                type: "varchar(150)",
                nullable: false,
                defaultValue: "");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropColumn(
                name: "Senha",
                table: "Users");
        }
    }
}
