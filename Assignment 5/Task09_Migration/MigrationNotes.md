# Migration and metadata
Read the old file line by line, validate every row, and write rejected rows plus line number/reason to a reject report.
Send valid rows to PassLoader in bounded batches of 1,000. Use a unique pass_id key, transaction boundaries, row counts,
and a reconciliation report. For quoted CSV input, use the CSV parser from PassStore rather than String.split.
Use Connection.getMetaData() to print database product/version, driver name/version and table names.
