package net.mmt_entertaiment.cynbom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mmt.cynbom.databinding.ActivityOfflineBinding

class OfflineActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOfflineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityOfflineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bouton réessayer
        binding.btnRetry.setOnClickListener {
            // Vérifier la connexion et revenir à MainActivity
            finish()
        }
    }
}
