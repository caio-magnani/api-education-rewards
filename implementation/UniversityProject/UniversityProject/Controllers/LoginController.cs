using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using UniversityProject.Models;

namespace UniversityProject.Controllers
{
    public class LoginController : Controller
    {
        //private readonly ILogin<LoginController> _logger;
        private readonly DataBase _context;
        SqlConnection con = new SqlConnection();
        SqlCommand com = new SqlCommand();
        SqlDataReader dr;
        private readonly int _typeStudent = 1;
        private readonly int _typePartner = 2;

        public LoginController(DataBase context)
        {
            _context = context;
            //_logger = logger;
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        void connectionString()
        {
            con.ConnectionString = _context.connectionString;
        }

        [HttpPost]
        public ActionResult Verify(User user)
        {
            if (user.Email == null)
            {
                return NotFound();
            }

            connectionString();
            con.Open();
            com.Connection = con;
            com.CommandText = "SELECT * FROM USERS WHERE EMAIL='" + user.Email + "'AND SENHA='" + user.Senha + "'";
            dr = com.ExecuteReader();


            //user = (User)_context.Users.Select(d => d.Email == user.Email && d.Senha == user.Senha);
            //if (user.GetPermission() == _typeStudent)
            if (1 == 1)
            {
                if (dr.Read())
                {
                    con.Close();
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    con.Close();
                    return View("Error");
                }
            }
            //else if(user.GetPermission() == _typePartner)
            else if(1 == 1)
            {
                if (dr.Read())
                {
                    con.Close();
                    return View("StudentConstruction");
                }
                else
                {
                    con.Close();
                    return View("Error");
                }
            }
            else
            {
                con.Close();
                return View("Error");
            }

        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
