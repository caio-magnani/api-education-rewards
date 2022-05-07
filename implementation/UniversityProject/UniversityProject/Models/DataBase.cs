using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using UniversityProject.Models;

namespace UniversityProject.Models
{
    public class DataBase : DbContext
    {
        public DbSet<User> Users { get; set; }
        public DbSet<Student> Students { get; set; }
        public DbSet<Partner> Partner { get; set; }
        public string connectionString { get; set; } = @"Data Source=.\SQLExpress;Database=UniversityProjectLab;integrated Security=true"; 
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(connectionString: @"Data Source=.\SQLExpress;Database=UniversityProjectLab;integrated Security=true");
        }
        
    }
}
