using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Threading.Tasks;

namespace UniversityProject.Models
{
    public class User
    {
        [Key]
        public int Id { get; set; }

        [DisplayName("Nome")]
        [Required(ErrorMessage = "Este campo é obrigatório")]
        [Column(TypeName = "nvarchar(250)")]
        public string Nome { get; set; }

        [DisplayName("Email")]
        [Required(ErrorMessage = "Este campo é obrigatório")]
        [Column(TypeName = "varchar(100)")]
        public string Email { get; set; }

        [DisplayName("Senha")]
        [Required(ErrorMessage = "Este campo é obrigatório")]
        [Column(TypeName = "varchar(150)")]
        public string Senha { get; set; }


        //[DisplayName("TipoUsuario")]
        //[Required(ErrorMessage = "Este campo é obrigatório")]
        //[Column(TypeName = "INT")]
        //public int TipoUsuario { get; set; }

        //public int GetPermission()
        //{
        //    return 0;
        //}
    }
}
